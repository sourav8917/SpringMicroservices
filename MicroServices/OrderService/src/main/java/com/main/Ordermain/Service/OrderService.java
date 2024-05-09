package com.main.Ordermain.Service;

import com.main.Ordermain.DTO.Product;
import com.main.Ordermain.Entity.Order;
import com.main.Ordermain.Repo.OrderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    
    @Autowired
    private ProductServiceClient productServiceClient;

    Logger logger = LoggerFactory.getLogger(OrderService.class);


    public List<Order> getAllOrders() {
        List<Order> orderList = orderRepo.findAll();
        return orderList;
    }

    public List<Order> getListOrderByUserID(long userid) {
        List<Order> orders = orderRepo.findOrderByUserId(userid);
        List<Order> newOrdersList = new ArrayList<>(); // Creating a new ArrayList<Order>

        for (Order order : orders) {

            Product product = productServiceClient.getProduct(order.getProduct_id());

            order.setProductList(Collections.singletonList(product));

            newOrdersList.add(order);

        }
        return newOrdersList;
    }


    public void createOrder(LocalDateTime orderDate, String status, long userid) {

        UUID uuid = UUID.randomUUID();
        long orderid = uuid.hashCode();
        long productid = uuid.hashCode();
        orderRepo.createOrder(orderid, orderDate, status, productid, userid);
    }
}

