package com.example.ridesharing.model.user;

public class UserFactoryImpl implements UserFactory {
    @Override
    public User createUser(UserType type, String id, String name, String phoneNumber) {
        switch (type) {
            case RIDER:
                return new Rider(id, name, phoneNumber);
            case DRIVER:
                return new Driver(id, name, phoneNumber);
            default:
                throw new IllegalArgumentException("Unknown user type: " + type);
        }
    }
}
