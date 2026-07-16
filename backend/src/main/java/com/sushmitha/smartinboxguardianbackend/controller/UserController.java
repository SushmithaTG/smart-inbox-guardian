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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {

        User savedUser = userService.saveUser(user);

        if (savedUser == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email already exists!");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {

        boolean isLoggedIn = userService.loginUser(
                user.getEmail(),
                user.getPassword()
        );

        if (isLoggedIn) {
            return ResponseEntity.ok("Login Successful!");
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Invalid email or password!");
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