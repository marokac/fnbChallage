
package com.fnb.dao;

import com.fnb.model.Customer;
import java.util.List;

public interface CastomerDao {
	List<Customer> findAllCustomers();
	void registerUser(Customer cus);
        Customer getCus_ID(int cus_ID);
        boolean ValidateCastomer(String IDNumber);
       List<Customer> getCusByIDNUm(String IdNumber);
        
        
}
	
