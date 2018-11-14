
package com.fnb.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity(name = "Payments")
@Table(name = "Payments")
public class Payments {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @Column(name = "amount")
    private int amount;
    
   @OneToMany(mappedBy = "primaryKey.payment",cascade = CascadeType.ALL)
    private Set<PaymentsAllocation> paymentsAllocation = new HashSet<PaymentsAllocation>();

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<PaymentsAllocation> getPaymentsAllocation() {
        return paymentsAllocation;
    }

    public void setPaymentsAllocation(Set<PaymentsAllocation> paymentsAllocation) {
        this.paymentsAllocation = paymentsAllocation;
    }
    
    
    
}
