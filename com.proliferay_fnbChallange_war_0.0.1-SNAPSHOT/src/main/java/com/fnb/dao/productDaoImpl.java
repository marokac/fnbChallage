
package com.fnb.dao;

import com.fnb.model.OrderItem;
import com.fnb.model.Product;
import com.fnb.model.ProductPrice;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class productDaoImpl implements productDao {
 @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product> findAllProducts() {
      return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public void addProduct(Product product) {
       sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public void deleteProduct(int id) {
       Product  product=(Product) sessionFactory.getCurrentSession().load(Product.class,id);
       if(product!=null){
           sessionFactory.getCurrentSession().delete(product);
       }
    }
    @Override
    public void updateProduct(Product product) {
       sessionFactory.getCurrentSession().update(product);
    }
    
    
     @Override
     public void addProductPrice(ProductPrice price,int id){ 
       sessionFactory.getCurrentSession().save(price); 
       Product existingproduct = getByPro_ID(id);
       existingproduct.getProductPrice().add(price);
       updateProduct(existingproduct);
     }
     
     
   @Override
   public void updateProductPrice(ProductPrice price,int id){
   sessionFactory.getCurrentSession().update(price);
    Product existingproduct = getByPro_ID(id);
       existingproduct.getProductPrice().add(price);
       updateProduct(existingproduct);
   }
   
   @Override
    public Product getByPro_ID(int ID) {
       return (Product) sessionFactory.getCurrentSession().get(Product.class, ID);
    }

    @Override
    public List<Product> getProductAndPrice() {
      return sessionFactory.getCurrentSession().createQuery("FROM Product as p Left join p.productPrice as m WHERE m.product= p.id").list();
    }

    @Override
    public ProductPrice getProductPriceById(int id) {
       return (ProductPrice) sessionFactory.getCurrentSession().get(ProductPrice.class, id);
    }
}
