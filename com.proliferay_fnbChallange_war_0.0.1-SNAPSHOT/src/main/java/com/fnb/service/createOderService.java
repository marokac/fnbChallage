
package com.fnb.service;

import com.fnb.model.Oders;
import java.util.List;

public interface createOderService {
    void addItem();
    void saveOrder();
    List<Oders> findUseOrders();  
}
