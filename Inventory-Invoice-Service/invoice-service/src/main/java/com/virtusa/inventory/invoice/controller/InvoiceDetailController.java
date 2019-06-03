package com.virtusa.inventory.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.virtusa.inventory.invoice.model.InvoiceDetail;
import com.virtusa.inventory.invoice.service.InvoiceDetailService;

import java.util.List;

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

	@GetMapping("/invoice/{invoiceId}")
	public List<InvoiceDetail> fetchInvoiceDetailsByInvNo(@PathVariable Integer invoiceId){
return invoiceDetialService.findByInvoiceId(invoiceId);

	}
	
	
}
