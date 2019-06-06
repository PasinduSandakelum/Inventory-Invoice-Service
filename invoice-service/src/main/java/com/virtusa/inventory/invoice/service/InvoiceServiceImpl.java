package com.virtusa.inventory.invoice.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.inventory.invoice.model.Invoice;
import com.virtusa.inventory.invoice.model.LoyaltyCard;
import com.virtusa.inventory.invoice.repository.InvoiceRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	@Override
	public Optional<Invoice> findById(Integer id) {
		return invoiceRepository.findById(id);
	}

	@Override
	public void updateCustomerPoints(Invoice invoice, BigDecimal total) {

//		Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoice.getId());
		Double points = 10.0;

		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<LoyaltyCard> responseEntity;
		HttpEntity<String> httpEntity = new HttpEntity<String>("", headers);
		responseEntity = restTemplate
				.exchange("http://localhost:9090/loyalty/card/update/customer/".concat(invoice.getCustomerId().toString())
						+ "?points=".concat(points.toString()), HttpMethod.GET, httpEntity, LoyaltyCard.class);
		System.out.println(responseEntity.getBody().getName().toString());
//		  invoice2.setLoyaltyCard(responseEntity.getBody()); return invoice2; }

	}

    @Override
    public List<Invoice> findByDate(Date date) {
        return invoiceRepository.findByDate(date);
    }

}
