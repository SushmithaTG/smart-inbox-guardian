//package com.sushmitha.smartinboxguardianbackend.controller;
//
//import com.sushmitha.smartinboxguardianbackend.model.User;
//import com.sushmitha.smartinboxguardianbackend.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/test")
//    public User getUser() {
//
//        User user = new User(
//                "Sushmitha",
//                "sushmithathangavel5@gmail.com",
//                "testpassword123"
//        );
//
//        return userService.saveUser(user);
//    }
//}
package com.sushmitha.smartinboxguardianbackend.controller;

import com.sushmitha.smartinboxguardianbackend.model.User;
import com.sushmitha.smartinboxguardianbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "User deleted successfully!";
    }
}