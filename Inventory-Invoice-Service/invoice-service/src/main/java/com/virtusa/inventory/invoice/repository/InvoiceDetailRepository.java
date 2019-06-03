package com.virtusa.inventory.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.inventory.invoice.model.InvoiceDetail;

import java.util.List;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {

    List<InvoiceDetail> findByinvoiceId(Integer invoiceId) ;
}
