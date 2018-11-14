package com.fnb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "Oders")
@Table(name = "Oders")
public class Oders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany(mappedBy = "primaryKey.order",cascade = CascadeType.ALL)
    private Set<PaymentsAllocation> paymentsAllocation = new HashSet<PaymentsAllocation>();
    
    @ManyToOne
    @JoinColumn(name = "cus_id", nullable = false)
    private Customer customer;

   
   @OneToMany(mappedBy="order")
   private Set<OrderItem> orderItems;
   
     @Column(name = "invoiceNum")
    private String invoiceNum;
     
      @Column(name = "oderDate")
    private Date oderDate;
      
       @Column(name = "invoiceDate")
    private Date invoiceDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getOderDate() {
        return oderDate;
    }

    public void setOderDate(Date oderDate) {
        this.oderDate = oderDate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<PaymentsAllocation> getPaymentsAllocation() {
        return paymentsAllocation;
    }

    public void setPaymentsAllocation(Set<PaymentsAllocation> paymentsAllocation) {
        this.paymentsAllocation = paymentsAllocation;
    }
    
    
    

}
