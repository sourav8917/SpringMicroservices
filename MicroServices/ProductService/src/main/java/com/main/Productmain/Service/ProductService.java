package com.main.Productmain.Service;

import com.main.Productmain.Entity.Product;
import com.main.Productmain.Repo.ProductRepo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getProducts(){
        List<Product> productList= productRepo.findAll();
        return productList;
    }
    public Product getProduct(long productid){
        Product product= productRepo.findById(productid);
        return product;
    }
}
