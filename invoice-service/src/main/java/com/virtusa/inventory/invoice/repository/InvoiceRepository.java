package com.virtusa.inventory.invoice.repository;

import com.virtusa.inventory.invoice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    List<Invoice> findByDate(Date date);
}
