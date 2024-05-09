package com.main.Usermain.Controller;

import com.main.Usermain.Entity.User;
import com.main.Usermain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getAllUser")
    public List<User> getAllUsers() {

        List<User> users = userService.getAllUsers();
        return users;
    }


    @PostMapping("/getSingleUser")
    public User getSingleUser(@RequestParam("userid") long userid) {
        System.out.println(userid);
        User user = userService.getSingleUser(userid);
        return user;
    }

    @PostMapping("/createuser")
    public void createUser(@RequestParam("user_name") String user_name,
                             @RequestParam("user_email") String user_email,
                             @RequestParam("user_mobno") String user_mobno,
                             @RequestParam("user_address") String user_address){

        userService.createUser(user_name,user_email,user_mobno,user_address);

    }


}
