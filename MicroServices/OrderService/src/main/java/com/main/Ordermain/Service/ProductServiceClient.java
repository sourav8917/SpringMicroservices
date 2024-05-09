package com.main.Ordermain.Service;

import com.main.Ordermain.DTO.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCTSERVICE")
public interface ProductServiceClient {

    @PostMapping("/getProduct")
    public Product getProduct(@RequestParam("productid") long productid);
}
