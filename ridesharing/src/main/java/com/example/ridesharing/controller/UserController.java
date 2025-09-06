package com.example.ridesharing.controller;

import com.example.ridesharing.model.user.User;
import com.example.ridesharing.model.user.UserType;
import com.example.ridesharing.model.user.UserUpdateRequest;
import com.example.ridesharing.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public User createUser(String type, String id, String name, String phoneNumber) {
        return userService.createUser(UserType.valueOf(type), id, name, phoneNumber);
    }

    @PutMapping
    // API: Update user profile
    public void updateUserProfile(UserUpdateRequest request) {
        userService.updateUserProfile(request);
    }


}
