package com.virtusa.inventory.invoice.service;

import java.util.Optional;

import com.virtusa.inventory.invoice.model.InvoiceDetail;

public interface InvoiceDetailService {

	void save(InvoiceDetail invoiceDetail);
	//InvoiceDetail fetchInvoiceItem(InvoiceDetail invoiceDetail);
	
	InvoiceDetail update(InvoiceDetail invoiceDetail, Integer id);
	void delete(Integer id);
}
