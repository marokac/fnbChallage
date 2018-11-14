/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fnb.service;

import com.fnb.model.Product;
import com.fnb.model.ProductPrice;
import java.util.List;
public interface productService {
   List<Product> findAllProducts();
   void addProduct(Product product);
   void deleteProduct(int id);
   void updateProduct(Product product);
   void addProductPrice(ProductPrice price,int prodId);
   void updateProductPrice(ProductPrice price,int prodId);
   List<Product> getProductAndPrice();
   ProductPrice getProductPriceById(int id);
}
