
package com.fnb.dao;

import com.fnb.model.Payments;
import java.util.List;

public interface PaymentsDao {
  List<Payments> getAllPayments();
 int save(Payments payment);
 
 void update(Payments payment);
 
 void view(Payments payment);
 
 void delete(int id);
 Payments getByPay_ID(int pay_ID);
}
