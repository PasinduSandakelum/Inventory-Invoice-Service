package com.virtusa.inventory.invoice.model;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

=======
import javax.persistence.*;
>>>>>>> 18c432c69e891ad82660d8d0a1156a7680772ea7
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(unique = true)
    private String code;

    private Date date;

    private BigDecimal total;

    private Double discountAmount;

    private Integer customerId;

    private Integer userId;
    
    @Transient
    private LoyaltyCard loyaltyCard;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceDetail> invoiceDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

<<<<<<< HEAD
	public LoyaltyCard getLoyaltyCard() {
		return loyaltyCard;
	}

	public void setLoyaltyCard(LoyaltyCard loyaltyCard) {
		this.loyaltyCard = loyaltyCard;
	}
    
=======
    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
>>>>>>> 18c432c69e891ad82660d8d0a1156a7680772ea7
}
