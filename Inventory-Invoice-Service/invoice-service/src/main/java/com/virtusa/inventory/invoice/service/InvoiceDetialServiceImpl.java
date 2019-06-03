package com.virtusa.inventory.invoice.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.inventory.invoice.model.InvoiceDetail;
import com.virtusa.inventory.invoice.model.Item;
import com.virtusa.inventory.invoice.repository.InvoiceDetailRepository;
import com.virtusa.inventory.invoice.repository.InvoiceRepository;

@Service
public class InvoiceDetialServiceImpl implements InvoiceDetailService {

	@Autowired
	InvoiceDetailRepository invoiceDetialRepository;
	
	@Override
	public void save(InvoiceDetail invoiceDetail) {
		invoiceDetialRepository.save(invoiceDetail);
		
	}
	
//	@Override
//	public InvoiceDetail fetchInvoiceItem(InvoiceDetail invoiceDetail) {
//		
//		Optional<InvoiceDetail> optionalInvoiceDetail = invoiceDetialRepository.findById(invoiceDetail.getId());
//		if (optionalInvoiceDetail.isPresent()) {
//			
//			HttpHeaders httpHeaders=new HttpHeaders();
//
//			OAuth2AuthenticationDetails oAuth2AuthenticationDetails =(OAuth2AuthenticationDetails)
//					SecurityContextHolder.getContext().getAuthentication().getDetails();
//
//			oAuth2AuthenticationDetails.getTokenValue();
//			httpHeaders.add("Authorization","bearer".concat(oAuth2AuthenticationDetails.getTokenValue()));
//
//			
//			ResponseEntity<Item[]> responseEntity;
//			HttpEntity<String> httpEntity=new HttpEntity<>("",httpHeaders);
//			responseEntity=RestTemplate.exchange("http://item-service/item/items/".
//					 concat(invoiceDetail.getId().toString()),HttpMethod.GET,httpEntity, Item[].class);
//
//			 		InvoiceDetail invoiceDetail1=optionalInvoiceDetail.get();
//			 		invoiceDetail1.setItem(responseEntity.getBody());
//					
//			return invoiceDetail1;
//		}else {
//			return null;
//		}
//	}

	@Override
	public void delete(Integer id) {
		
		invoiceDetialRepository.deleteById(id);
		
		
	}

	@Override
	public List<InvoiceDetail> findByInvoiceId(Integer invoiceId) {
		return invoiceDetialRepository.findByinvoiceId(invoiceId);
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
