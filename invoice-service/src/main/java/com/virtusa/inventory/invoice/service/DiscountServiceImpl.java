package com.virtusa.inventory.invoice.service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.SortedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.inventory.invoice.model.Discount;
import com.virtusa.inventory.invoice.repository.DiscountRepository;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public List<Discount> fetchAll() {

        return discountRepository.findAll();
    }

    @Override
    public Optional<Discount> findOne(Integer id) {

        Optional<Discount> optional = discountRepository.findById(id);

        if (optional.isPresent()) {
            return optional;
        } else {
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

        if (discounts.stream().noneMatch(s -> s.getPriceRange().equals(discount.getPriceRange()))) {
            return discountRepository.save(discount);
        } else {
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

}
