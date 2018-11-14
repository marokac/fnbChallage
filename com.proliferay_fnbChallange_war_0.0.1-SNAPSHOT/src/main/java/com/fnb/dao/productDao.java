
package com.fnb.dao;
import com.fnb.model.Product;
import com.fnb.model.ProductPrice;
import java.util.List;

public interface productDao {
   List<Product> findAllProducts();
   void addProduct(Product product);
   void deleteProduct(int id);
   void updateProduct(Product product);
   void addProductPrice(ProductPrice price,int pro_id);
   void updateProductPrice(ProductPrice price,int id);
   Product getByPro_ID(int oder_ID);
   List<Product> getProductAndPrice();
   ProductPrice getProductPriceById(int id);
}
