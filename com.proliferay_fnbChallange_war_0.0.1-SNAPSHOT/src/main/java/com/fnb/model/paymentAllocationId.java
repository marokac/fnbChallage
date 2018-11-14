
package com.fnb.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class paymentAllocationId implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    private Oders order;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Payments payment;

    public Oders getOrder() {
        return order;
    }

    public void setOrder(Oders order) {
        this.order = order;
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }
    
    
}
