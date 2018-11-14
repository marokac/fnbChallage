package com.fnb.controller;

import com.fnb.model.Customer;
import com.fnb.model.Product;
import com.fnb.model.ProductPrice;
import com.fnb.service.CustomerService;
import com.fnb.service.createOderService;
import com.fnb.service.productService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {    
    @Autowired
    private CustomerService customerService;
    @Autowired
    private createOderService oderService; 
     @Autowired
    private productService prodService;
    
    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public @ResponseBody String registerUser(@RequestBody Customer cus) {
        customerService.registerUser(cus);
        return "OK";
    }
    
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public @ResponseBody List login(@RequestBody String cusID) {
        boolean isValid=customerService.ValidateCastomer(cusID);
        if(isValid){
        return customerService.getCusByIDNUm(cusID);
        }
        else{
        List l=new ArrayList();
        l.add(202);
        return l;
        }
    }
    
    @RequestMapping(value = "/fnb/getAllCustomers", method = RequestMethod.GET)
    public @ResponseBody List getAllUsers() {
        return customerService.findAllCustomers();
    }
    
     @RequestMapping(value = "/fnb/addProducts", method = RequestMethod.POST)
      public @ResponseBody String addProducts(@RequestBody Product prod) {
        prodService.addProduct(prod);
        return "OK";
    }
      
     
   @RequestMapping(value = "/addprice", method=RequestMethod.POST)
   public @ResponseBody String getOrder(@RequestParam("productId") int productId,
           @RequestBody ProductPrice price){
       prodService.addProductPrice(price,productId);
        return "OK";
   }
   
   @RequestMapping(value = "/updatePrice", method=RequestMethod.POST)
   public @ResponseBody String updateProductPrice(@RequestParam("productId") int productId,
           @RequestBody ProductPrice price){
            prodService.updateProductPrice(price,productId);
            return "OK";
   }
   
   
    @RequestMapping(value = "/api/getAllProducts", method = RequestMethod.GET)
    public @ResponseBody List getAllProduct() {
        return prodService.findAllProducts();
    }
    
     @RequestMapping(value = "/api/listAllProductsAndPrices", method = RequestMethod.GET)
    public @ResponseBody List listAllProductsAndPrices() {
        return prodService.getProductAndPrice();
    }
    
    @RequestMapping(value="/api/product/{id}/price", method = RequestMethod.GET)
    public @ResponseBody ProductPrice listAllProductsAndPricesh(@PathVariable("id") int id) {
        return prodService.getProductPriceById(id);
    }
    
    
    
}
