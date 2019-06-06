package com.virtusa.inventory.invoice.service;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.SortedMap;
import java.util.stream.Collectors;

import com.virtusa.inventory.invoice.model.Invoice;
import com.virtusa.inventory.invoice.repository.InvoiceRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.inventory.invoice.model.Discount;
import com.virtusa.inventory.invoice.repository.DiscountRepository;

@Service
public class DiscountServiceImpl implements DiscountService {


	@Autowired
	private DiscountRepository discountRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Override
	public List<Discount> fetchAll() {

		return discountRepository.findAll();
	}
	
	@Override
	public Optional<Discount> findOne(Integer id) {

		Optional<Discount> optional =  discountRepository.findById(id);

		if (optional.isPresent()){
			return optional;
		}
		else {
			return null;
		}

	}
	
	@Override
	public Long getNoOfItems() {
		return discountRepository.count();
	}
	
	@Override
	public Discount save(Discount discount) {

		List<Discount> discounts = discountRepository.findAll();

		if (discounts.stream().noneMatch(s-> s.getPriceRange().equals(discount.getPriceRange()))){
			return discountRepository.save(discount);
		}else {
			return null;

		}


//		for (Discount item : discounts) {
//			if (item.getPriceRange().equals(discount.getPriceRange())) {
//				matched = true;
//				break;
//			} else {
//				matched = false;
//			}
//		}

        //return  discountRepository.save(discount);
    }

    @Override
    public Discount update(Discount discount, Integer id) {

        List<Discount> discounts = discountRepository.findAll();

        if ((discounts.stream().anyMatch(dis -> dis.getId().equals(id))) == true) {

            Discount discount1 = new Discount();
            discount1.setId(id);
            discount1.setPriceRange(discount.getPriceRange());
            discount1.setDiscount(discount.getDiscount());
            return discountRepository.save(discount1);

        } else {

            return null;

        }

    }

    @Override
    public void delete(Integer id) {

        discountRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        discountRepository.deleteAll();
    }

	public BigDecimal getDiscount(Invoice invoice){

		List<Discount> discounts = discountRepository.findAll();
		BigDecimal discountedPrice = null;

		for (Discount discount: discounts) {
			if ( BigDecimal.valueOf(discount.getPriceRange()).compareTo(invoice.getTotal()) <= 0) {
				discountedPrice = BigDecimal.valueOf(discount.getDiscount()).multiply(invoice.getTotal());
			}else{
				return null;
			}
		}
		return discountedPrice;
	}

	@Override
	public Double getDiscount(BigDecimal amount){

		//List<Discount> discounts = discountRepository.findAll();
		List<Discount> discounts = discountRepository.findAll().stream()
				.sorted((val1,val2)-> val1.getPriceRange().compareTo(val2.getPriceRange()))
				.collect(Collectors.toList());
		Double dis = Double.valueOf(0);


		for (Discount discount: discounts){

			int nextIndex = discounts.indexOf(discount)+1;

			if((amount.compareTo(BigDecimal.valueOf(discount.getPriceRange())) <0)){
				return dis = Double.valueOf(0);
			}
			else if (discounts.indexOf(discount)==discounts.size()-1){
				if (amount.compareTo(BigDecimal.valueOf(discount.getPriceRange())) >= 0){
					return discount.getDiscount();
				}
				else {
					return dis = Double.valueOf(0);
				}
			}
			else if((amount.compareTo(BigDecimal.valueOf(discount.getPriceRange())) >= 0) && (amount.compareTo(BigDecimal.valueOf(discounts.get(nextIndex).getPriceRange())) < 0) && (discounts.indexOf(discount)!=discounts.size()-1)){
				return dis = discount.getDiscount();
			}
			else {
				continue;
			}
		}
		return dis;
	}

}
