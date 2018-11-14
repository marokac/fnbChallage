
package com.fnb.service;

import com.fnb.dao.productDao;
import com.fnb.model.Product;
import com.fnb.model.ProductPrice;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
@Transactional
public class productServiceImpl implements productService {
@Autowired
  private productDao productDao;
    @Override
    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }

    @Override
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productDao.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
    productDao.updateProduct(product);
    }

    @Override
    public void addProductPrice(ProductPrice price,int prodId) {
       productDao.addProductPrice(price,prodId);
    }

    @Override
    public void updateProductPrice(ProductPrice price,int prodId) {
      productDao.updateProductPrice(price,88);
    }

    @Override
    public List<Product> getProductAndPrice() {
        return productDao.getProductAndPrice();
    }

    @Override
    public ProductPrice getProductPriceById(int id) {
        return productDao.getProductPriceById(id);
    }
    
}
