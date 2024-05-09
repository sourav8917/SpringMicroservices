package com.main.Productmain.controller;

import com.main.Productmain.Entity.Product;
import com.main.Productmain.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        List<Product> productList = productService.getProducts();
        return productList;
    }
    @PostMapping("/getProduct")
    public Product getProduct(@RequestParam("productid") long productid){
        System.out.println(productid);
        Product product = productService.getProduct(productid);
        return product;
    }
}
