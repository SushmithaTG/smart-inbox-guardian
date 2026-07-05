package com.sushmitha.smartinboxguardianbackend.controller;


import com.sushmitha.smartinboxguardianbackend.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {

    @GetMapping("/test")
    public User getUser() {

        User user = new User(

                "Sushmitha",
                "sushmithathangavel5@gmail.com",
                "testpassword123"
        );

        return user;
    }
}