package com.main.Usermain.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private long order_id;
    private LocalDateTime order_date;
    private String status;
    private long product_id;
    private List<Product> productList;

}
