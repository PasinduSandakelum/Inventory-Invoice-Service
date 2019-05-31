package com.virtusa.inventory.invoiceservice.controller;

import com.virtusa.inventory.invoiceservice.model.Invoice;
import com.virtusa.inventory.invoiceservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emscloud")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoice")
    public ResponseEntity<List<Invoice>> fetchAll() {
        return ResponseEntity.ok(invoiceService.findAll());
    }

    @PostMapping("/invoice")
    public ResponseEntity<Invoice> create(Invoice invoice) {
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
