package com.virtusa.inventory.invoiceservice.service;

import com.virtusa.inventory.invoiceservice.model.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List<Invoice> findAll();

    Invoice save(Invoice invoice);

    Optional<Invoice> findById(Integer id);
}
