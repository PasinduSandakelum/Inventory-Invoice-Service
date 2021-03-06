package com.virtusa.inventory.invoice.service;

import com.virtusa.inventory.invoice.criteria.InvoiceCriteria;
import com.virtusa.inventory.invoice.model.Invoice;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List<Invoice> findAll();

    Invoice save(Invoice invoice);

    Optional<Invoice> findById(Integer id);
    
    void updateCustomerPoints(Invoice invoice, BigDecimal total);

    List<Invoice> findByDate(InvoiceCriteria invoiceSearch) throws ParseException;
}
