package com.main.Usermain.Service;

import com.main.Usermain.DTO.Order;
import com.main.Usermain.Entity.User;
import com.main.Usermain.Repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderServiceClient orderServiceClient;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    //    Getting Single AllUser......................................
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    //    Getting SingleUser.............................
    public User getSingleUser(long userId) {
        User user = userRepo.findById(userId);
        logger.info("User: {}", user);

        List<Order> listOrderByUserID = orderServiceClient.getListOrderByUserID(user.getUser_id());

        user.setOrderList(listOrderByUserID);
        return user;
    }

    //    Creating new User Service...................
    public void createUser(String userName, String userEmail, String userMobno, String userAddress) {

        UUID uuid = UUID.randomUUID();
        long userid = uuid.hashCode();
        userRepo.createUser(String.valueOf(userid), userName, userEmail, userMobno, userAddress);

    }
}
