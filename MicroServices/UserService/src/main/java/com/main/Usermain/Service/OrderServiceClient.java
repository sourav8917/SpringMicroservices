package com.main.Usermain.Service;

import com.main.Usermain.DTO.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ORDERSERVICE")
public interface OrderServiceClient {

    @PostMapping("/getListOrderByUserID")
    public List<Order> getListOrderByUserID(@RequestParam("userid") long userid);
}
