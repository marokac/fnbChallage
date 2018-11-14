
package com.fnb.dao;
import com.fnb.model.Payments;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentDaoImpl implements PaymentsDao {
 @Autowired
 private SessionFactory sessionFactory;
    @Override
    public List<Payments> getAllPayments() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Payments.class);
  return criteria.list();
    }

    @Override
    public int save(Payments payment) {
      return (Integer) sessionFactory.getCurrentSession().save(payment);
    }

    @Override
    public void update(Payments payment) {
       sessionFactory.getCurrentSession().merge(payment);
    }

    @Override
    public void view(Payments payment) {
        sessionFactory.getCurrentSession().merge(payment);
    }

    @Override
    public void delete(int id) {
        Payments p = getByPay_ID(id);
  sessionFactory.getCurrentSession().delete(p);
    }
    
 @Override
 public Payments getByPay_ID(int pay_ID) {
  return (Payments) sessionFactory.getCurrentSession().get(Payments.class, pay_ID);
 }
    
}
