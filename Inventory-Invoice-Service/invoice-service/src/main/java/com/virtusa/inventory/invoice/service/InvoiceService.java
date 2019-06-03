package com.virtusa.inventory.invoice.service;

import com.virtusa.inventory.invoice.model.Invoice;
import com.virtusa.inventory.invoice.model.InvoiceDetail;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List<Invoice> findAll();

    Invoice save(Invoice invoice);

    Optional<Invoice> findById(Integer id);


}
