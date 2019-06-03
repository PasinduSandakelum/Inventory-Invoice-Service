package com.virtusa.inventory.invoice.repository;

import com.virtusa.inventory.invoice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
