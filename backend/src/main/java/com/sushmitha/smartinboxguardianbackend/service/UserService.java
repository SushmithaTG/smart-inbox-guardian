package com.sushmitha.smartinboxguardianbackend.service;

import com.sushmitha.smartinboxguardianbackend.model.User;
import com.sushmitha.smartinboxguardianbackend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Get all users from database
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Save a new user
    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return null;
        }
        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    // Update an existing user
    public User updateUser(Long id, User updatedUser) {

        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());

            return userRepository.save(user);
        }

        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            return false;
        }

        return passwordEncoder.matches(password, user.getPassword());
    }
}