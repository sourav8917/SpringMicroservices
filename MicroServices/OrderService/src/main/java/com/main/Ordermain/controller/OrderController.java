package com.main.Ordermain.controller;

import com.main.Ordermain.Entity.Order;
import com.main.Ordermain.Repo.OrderRepo;
import com.main.Ordermain.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders() {
        List<Order> orderList = orderService.getAllOrders();
        return orderList;
    }

    @PostMapping("/getListOrderByUserID")
    public List<Order> getListOrderByUserID(@RequestParam("userid") long userid) {
        List<Order> order = orderService.getListOrderByUserID(userid);
        return order;
    }

    @PostMapping("/createOrder")
    public void createOrder(@RequestParam("orderDate") LocalDateTime orderDate,
                            @RequestParam("status") String status,
                            @RequestParam("userId") long userid) {

        orderService.createOrder(orderDate,status,userid);
    }
}
