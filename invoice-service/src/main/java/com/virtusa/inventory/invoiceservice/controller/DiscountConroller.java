package com.virtusa.inventory.invoiceservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.invoiceservice.model.Discount;
import com.virtusa.inventory.invoiceservice.service.DiscountService;

@RestController
@RequestMapping(value = "/imscloud")
public class DiscountConroller {
	
	@Autowired
	private DiscountService discountService;
	
	@RequestMapping(value = "/discount", method = RequestMethod.GET)
	public ResponseEntity<Optional<Discount>> fetchOne(@PathVariable Integer id) {
		
		Optional<Discount> optional =  discountService.findOne(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional);
		}else {
			return null;
		}
		
	}
	
//	public ResponseEntity<Discount> save(@RequestBody Discount discount) {
//		boolean matched = false;
//
//		List<Discount> categoryTable = categoryService.fetchAll();
//		for (Category item : categoryTable) {
//			if (item.getType().equals(category.getType().toLowerCase())) {
//				matched = true;
//				break;
//			} else {
//				matched = false;
//			}
//		}
//
//		if (category.getType() != null && matched == false) {
//			Category newCategory = new Category();
//			newCategory.setId(category.getId());
//			newCategory.setPointRange(category.getPointRange());
//			newCategory.setType(category.getType().toLowerCase());
//			return ResponseEntity.ok(categoryService.save(newCategory));
//
//		} else {
//			throw new CategoryAlreadyExistException("Couldn't add - Category already exists!");
//		}
//	}

}
