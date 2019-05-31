package com.virtusa.inventory.invoiceservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.inventory.invoiceservice.model.Discount;
import com.virtusa.inventory.invoiceservice.repository.DiscountRepository;

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
		return discountRepository.findById(id);
	}
	
	@Override
	public Long getNoOfItems() {
		return discountRepository.count();
	}
	
	@Override
	public Discount save(Discount discount) {
		return  discountRepository.save(discount);
	}
	
	@Override
	public Discount update(Discount discount) {
		return discountRepository.save(discount);
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
