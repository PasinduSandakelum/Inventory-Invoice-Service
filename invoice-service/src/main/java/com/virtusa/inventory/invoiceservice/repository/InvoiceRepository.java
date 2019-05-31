package com.virtusa.inventory.invoiceservice.repository;

import com.virtusa.inventory.invoiceservice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
