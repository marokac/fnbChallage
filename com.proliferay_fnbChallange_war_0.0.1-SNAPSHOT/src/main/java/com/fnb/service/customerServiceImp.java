
package com.fnb.service;

import com.fnb.dao.CastomerDao;
import com.fnb.model.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
public class customerServiceImp implements CustomerService {
  @Autowired
  private CastomerDao customerDao;
  
   @Override
   public List<Customer> findAllCustomers() {
      return customerDao.findAllCustomers();
    }

    @Override
    public void registerUser(Customer cus) {
       customerDao.registerUser(cus);
    }

    @Override
    public boolean ValidateCastomer(String IDNumber) {
       return customerDao.ValidateCastomer(IDNumber);
    }

    @Override
    public List<Customer> getCusByIDNUm(String IdNumber) {
       return customerDao.getCusByIDNUm(IdNumber);
    }
    
}
