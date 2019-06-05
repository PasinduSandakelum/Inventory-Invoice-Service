package com.virtusa.inventory.invoice.service;

import com.virtusa.inventory.invoice.model.Invoice;

<<<<<<< HEAD
import java.math.BigDecimal;
=======
import java.util.Date;
>>>>>>> 18c432c69e891ad82660d8d0a1156a7680772ea7
import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List<Invoice> findAll();

    Invoice save(Invoice invoice);

    Optional<Invoice> findById(Integer id);
<<<<<<< HEAD
    
    void updateCustomerPoints(Invoice invoice, BigDecimal total);
=======

    List<Invoice> findByDate(Date date);
>>>>>>> 18c432c69e891ad82660d8d0a1156a7680772ea7
}
