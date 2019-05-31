package com.virtusa.inventory.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.invoice.model.InvoiceDetail;
import com.virtusa.inventory.invoice.service.InvoiceDetailService;

@RestController
public class InvoiceDetailController {

	@Autowired
	InvoiceDetailService invoiceDetialService;
	
	
	@DeleteMapping("/invoicedetail/{id}")
	public void delete(@PathVariable Integer id){
		
		
		invoiceDetialService.delete(id);
		
	}
	
	
	@PutMapping("/invoicedetail/{id}")
	public void delete(@RequestBody InvoiceDetail invoiceDetail,@PathVariable Integer id){
		
		
		invoiceDetialService.update(invoiceDetail, id);
		
	}
	
	
	
	
}
