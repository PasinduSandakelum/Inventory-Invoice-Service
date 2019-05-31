package com.virtusa.inventory.invoice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.inventory.invoice.model.InvoiceDetail;
import com.virtusa.inventory.invoice.repository.InvoiceDetailRepository;
import com.virtusa.inventory.invoice.repository.InvoiceRepository;

@Service
public class InvoiceDetialServiceImpl implements InvoiceDetailService {

	@Autowired
	InvoiceDetailRepository invoiceDetialRepository;
	
	@Override
	public void delete(Integer id) {
		
		invoiceDetialRepository.deleteById(id);
		
		
	}



	@Override
	public InvoiceDetail update(InvoiceDetail invoiceDetail, Integer id) {
		
			
			return invoiceDetialRepository.findById(id).map(invoiceDet->
			{
				invoiceDet.setItemId(invoiceDetail.getItemId());
				invoiceDetail.setQuantity(invoiceDet.getQuantity());
				
				//invoiceDetail.setAmount(invoiceDet.getQuantity()*invoiceDet.get);
				return invoiceDetialRepository.save(invoiceDet);
			}).orElseGet( ()->{
				
				invoiceDetail.setId(id);
				return invoiceDetialRepository.save(invoiceDetail);
					
				
			});
			
			

	}
	
	

}
