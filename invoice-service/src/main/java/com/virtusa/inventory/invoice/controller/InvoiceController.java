package com.virtusa.inventory.invoice.controller;

import com.virtusa.inventory.invoice.model.Invoice;
import com.virtusa.inventory.invoice.service.InvoiceService;

import org.hibernate.annotations.Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

<<<<<<< HEAD
import java.math.BigDecimal;
=======
import javax.websocket.server.PathParam;
import java.util.Date;
>>>>>>> 18c432c69e891ad82660d8d0a1156a7680772ea7
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imscloud")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    
    
    @Bean
    private RestTemplate restTemplate(RestTemplateBuilder builder) {
    	return builder.build();
    }

    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> fetchAll() {
        return ResponseEntity.ok(invoiceService.findAll());
    }
    
    @GetMapping("/invoice/points/{total}")
    public ResponseEntity<HttpStatus> updateCustomerPoints(@PathVariable BigDecimal total) {
    	Invoice invoice = new Invoice();
    	invoice.setId(1);
    	invoice.setCustomerId(1);
    	invoiceService.updateCustomerPoints(invoice, total);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/invoice")
    public ResponseEntity<List<Invoice>> fetchByDate(@PathParam(value = "date") Date date) {
        return ResponseEntity.ok(invoiceService.findByDate(date));
    }

    @PostMapping("/invoice")
    public ResponseEntity<Invoice> create(@RequestBody Invoice invoice) {
        return ResponseEntity.ok(invoiceService.save(invoice));
    }

    @PutMapping("/invoice/{id}")
    public ResponseEntity<Invoice> update(@PathVariable Integer id, Invoice invoice) {
        Optional<Invoice> optionalInvoice = invoiceService.findById(id);
        if (!optionalInvoice.isPresent()) {
            ResponseEntity.notFound().build();
        }
        invoice.setId(id);
        return ResponseEntity.ok(invoiceService.save(invoice));
    }
}
