
package com.fnb.service;

import com.fnb.model.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public interface CustomerService {
  List<Customer> findAllCustomers();
  void registerUser(Customer cus);  
  boolean ValidateCastomer(String IDNumber);
  List<Customer> getCusByIDNUm(String IdNumber);
}
