package com.main.Usermain.Entity;

import com.main.Usermain.DTO.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Long user_id;
    private String user_name;
    private String user_email;
    private String user_mobno;
    private String user_address;
    @Transient
    private List<Order> orderList;


}
