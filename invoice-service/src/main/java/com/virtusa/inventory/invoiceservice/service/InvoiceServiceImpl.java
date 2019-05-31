package com.virtusa.inventory.invoiceservice.service;

import com.virtusa.inventory.invoiceservice.model.Invoice;
import com.virtusa.inventory.invoiceservice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return invoiceRepository.save(invoice);
    }

    @Override
    public Optional<Invoice> findById(Integer id){
        return invoiceRepository.findById(id);
    }

}
