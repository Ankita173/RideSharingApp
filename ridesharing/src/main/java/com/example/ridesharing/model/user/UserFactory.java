package com.example.ridesharing.model.user;

public interface UserFactory {
    User createUser(UserType type, String id, String name, String phoneNumber);
}
