package com.virtusa.inventory.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.invoice.model.InvoiceDetail;
import com.virtusa.inventory.invoice.service.InvoiceDetailService;

@RestController
@RequestMapping(value="/item")
public class InvoiceDetailController {

	@Autowired
	InvoiceDetailService invoiceDetialService;
	
	@RequestMapping(value="/invoiceDetails",method = RequestMethod.POST)
	public void save(@RequestBody InvoiceDetail invoiceDetail)
	{
		invoiceDetialService.save(invoiceDetail);
	}
	
	@DeleteMapping("/invoicedetail/{id}")
	public void delete(@PathVariable Integer id){
		
		
		invoiceDetialService.delete(id);
		
	}
	
	
	@PutMapping("/invoicedetail/{id}")
	public void delete(@RequestBody InvoiceDetail invoiceDetail,@PathVariable Integer id){
		
		
		invoiceDetialService.update(invoiceDetail, id);
		
	}
	
	
	
	
}
