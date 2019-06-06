package com.virtusa.inventory.invoice.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.virtusa.inventory.invoice.model.Discount;

public interface DiscountService {

	List<Discount> fetchAll();

	Optional<Discount> findOne(Integer id);

	Long getNoOfItems();

	Discount save(Discount discount);

	Discount update(Discount discount, Integer id);

	void delete(Integer id);

	void deleteAll();

    Double getDiscount(BigDecimal amount);

}