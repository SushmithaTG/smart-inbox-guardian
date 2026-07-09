package com.sushmitha.smartinboxguardianbackend.controller;

import com.sushmitha.smartinboxguardianbackend.model.User;
import com.sushmitha.smartinboxguardianbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public User getUser() {

        User user = new User(
                "Sushmitha",
                "sushmithathangavel5@gmail.com",
                "testpassword123"
        );

        return userService.saveUser(user);
    }
}