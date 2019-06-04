package com.virtusa.inventory.invoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.inventory.invoice.model.InvoiceDetail;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
	  List<InvoiceDetail> findByinvoiceId(Integer invoiceId) ;
}
