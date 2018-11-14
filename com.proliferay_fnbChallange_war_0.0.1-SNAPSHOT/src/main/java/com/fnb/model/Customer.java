
package com.fnb.model;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "Customer")
@Table(name = "Customer")
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   @OneToMany(mappedBy="customer")
   private Set<Oders> oders;
   
  @OneToMany(mappedBy="customer")
   private Set<Payments> payment;

    public Set<Payments> getAyment() {
        return payment;
    }

    public void setAyment(Set<Payments> payment) {
        this.payment = payment;
    }
  
    public Set<Oders> getOrders() {
        return oders;
    }

    public void setOrders(Set<Oders> orders) {
        this.oders = orders;
    }
   
   @Column(name = "firstName")
   private String firstName;
   
   @Column(name = "surName")
   private String surName;
   
   @Column(name = "IdNumber")
   private String IdNumber;
   
   @Column(name = "dateOfBirth")
   private String dateOfBirth;  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(String IdNumber) {
        this.IdNumber = IdNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
