package com.virtusa.inventory.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.inventory.invoice.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {

}
