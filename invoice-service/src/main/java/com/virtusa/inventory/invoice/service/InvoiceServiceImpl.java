package com.virtusa.inventory.invoice.service;

import com.virtusa.inventory.invoice.model.Invoice;
import com.virtusa.inventory.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findAll(){
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice save(Invoice invoice){
        invoice.getInvoiceDetails().forEach(i -> i.setInvoice(invoice));
        return invoiceRepository.save(invoice);
    }

    @Override
    public Optional<Invoice> findById(Integer id){
        return invoiceRepository.findById(id);
    }

    @Override
    public List<Invoice> findByDate(Date date) {
        return invoiceRepository.findByDate(date);
    }

}
