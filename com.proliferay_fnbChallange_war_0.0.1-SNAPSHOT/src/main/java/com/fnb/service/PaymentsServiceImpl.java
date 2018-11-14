/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fnb.service;

import com.fnb.dao.PaymentsDao;
import com.fnb.model.Payments;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentsServiceImpl implements PaymentsService{
@Autowired
private PaymentsDao payDao;
    @Override
    public List<Payments> getAllPayments() {
       return payDao.getAllPayments();
    }

    @Override
    public int save(Payments payment) {
        return payDao.save(payment);
    }

    @Override
    public void update(Payments payment) {
        payDao.update(payment);
    }

    @Override
    public void view(Payments payment) {
       payDao.view(payment);
    }

    @Override
    public void delete(int id) {
       payDao.delete(id);
    }

    @Override
    public Payments getByPay_ID(int pay_ID) {
      return payDao.getByPay_ID(pay_ID);
    }
    
}
