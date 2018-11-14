
package com.fnb.service;

import com.fnb.dao.createOder;
import com.fnb.model.Oders;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class createOrderServiceImpl implements createOderService {
@Autowired
  private createOder createOder;
    @Override
    public void addItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Oders> findUseOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
