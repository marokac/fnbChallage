
package com.fnb.dao;

import com.fnb.model.Customer;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class CastomerDaoImpl implements CastomerDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Customer> findAllCustomers() {
         return sessionFactory.getCurrentSession().createQuery("from Customer c order by c.firstName desc").list();
    }

    @Override
    public void registerUser(Customer cus) {
         sessionFactory.getCurrentSession().save(cus);
      }

    @Override
    public Customer getCus_ID(int cus_ID) {
         return (Customer) sessionFactory.getCurrentSession().get(Customer.class, cus_ID);
    }
   private HibernateTemplate hibernateTemplate;
   
  
    
    
       public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }  

    @Override
    public boolean ValidateCastomer(String IDNumber) {
          boolean isValidUser = false;
        String sqlQuery = "from Customer c where c.IdNumber=?";
        try {
           List userObj = (List) hibernateTemplate.find(sqlQuery, IDNumber);

            if(userObj != null && userObj.size() > 0) {
                isValidUser = true;
            }
      } catch(Exception e) {
            isValidUser = false;
        }
        return isValidUser;
    }

    @Override
    public List<Customer> getCusByIDNUm(String IdNumber) {
       return sessionFactory.getCurrentSession().createQuery("from Customer c where c.IdNumber=:IdNumber").list();
    }
    }
