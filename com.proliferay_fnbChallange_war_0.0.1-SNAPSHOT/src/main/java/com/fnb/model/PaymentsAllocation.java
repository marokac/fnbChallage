
package com.fnb.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name="PaymentsAllocation")
@Table(name = "PaymentsAllocation")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.payment",
        joinColumns = @JoinColumn(name = "pay_id")),
    @AssociationOverride(name = "primaryKey.order",
        joinColumns = @JoinColumn(name = "order_id")) })
public class PaymentsAllocation implements Serializable{
     @EmbeddedId
     private paymentAllocationId primaryKey = new paymentAllocationId();
     @Column(name = "amount")
     private int amount;
     
   

    public paymentAllocationId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(paymentAllocationId primaryKey) {
        this.primaryKey = primaryKey;
    }
  

    public int getAmount() {
        return amount;
    }

   
    public void setAmount(int amount) {
        this.amount = amount;
    }
 
    public Oders getOder() {
        return getPrimaryKey().getOrder();
    }
 
    public void setOder(Oders oder) {
        getPrimaryKey().setOrder(oder);
    }
 

    public Payments getPay() {
        return getPrimaryKey().getPayment();
    }
 
    public void setPay(Payments payment) {
        getPrimaryKey().setPayment(payment);
    }   
}
