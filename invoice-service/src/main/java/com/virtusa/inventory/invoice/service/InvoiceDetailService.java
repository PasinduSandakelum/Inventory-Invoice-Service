package com.virtusa.inventory.invoice.service;

import java.util.Optional;

import com.virtusa.inventory.invoice.model.InvoiceDetail;

public interface InvoiceDetailService {

	void delete(Integer id);
	
	

	InvoiceDetail update(InvoiceDetail invoiceDetail, Integer id);
	
}
