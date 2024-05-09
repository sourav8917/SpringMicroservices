package com.main.Ordermain.Repo;

import com.main.Ordermain.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {

    public List<Order> findAll();

    @Query(value = "SELECT * FROM order_db.orders o WHERE o.user_id = :id", nativeQuery = true)
    public List<Order> findOrderByUserId(@Param("id") long id);

    void createOrder(long orderid, LocalDateTime orderDate, String status, long productid, long userid);
}
