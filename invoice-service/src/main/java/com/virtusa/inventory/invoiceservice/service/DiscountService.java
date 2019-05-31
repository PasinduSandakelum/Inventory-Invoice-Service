package com.virtusa.inventory.invoiceservice.service;

import java.util.List;
import java.util.Optional;

import com.virtusa.inventory.invoiceservice.model.Discount;

public interface DiscountService {

	List<Discount> fetchAll();

	Optional<Discount> findOne(Integer id);

	Long getNoOfItems();

	Discount save(Discount discount);

	Discount update(Discount discount);

	void delete(Integer id);

	void deleteAll();

}