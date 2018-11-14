package com.fnb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;
    
   @OneToMany(mappedBy="product")
   @JsonIgnore
   private Set<OrderItem> orderItems;

    @OneToMany(mappedBy="product")
     @JsonIgnore
    private Set<ProductPrice> productPrice;
   
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<ProductPrice> getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Set<ProductPrice> ProductPrice) {
        this.productPrice = ProductPrice;
    }
    
}
