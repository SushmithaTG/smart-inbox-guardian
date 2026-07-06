package com.sushmitha.smartinboxguardianbackend.service;

import com.sushmitha.smartinboxguardianbackend.model.User;
import com.sushmitha.smartinboxguardianbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}