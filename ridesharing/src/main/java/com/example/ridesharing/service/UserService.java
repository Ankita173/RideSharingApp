package com.example.ridesharing.service;

import com.example.ridesharing.model.user.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private UserFactory userFactory;

    Map<String, User> users = new HashMap<>(); // Simulating a user database

    public User createUser(UserType type, String id, String name, String phoneNumber) {
        User user = userFactory.createUser(type, id, name, phoneNumber);
        System.out.println("User created: " + user.getType() + " - " + user.getName());
        users.put(id, user); // Save to "DB"
        return user;
    }

    public User getUser(String userId) {
        // Fetch user from DB (stubbed here)
        return users.get(userId);
    }

    // Update common profile info
    private void updateRiderProfile(Rider user, String newName, String newPhoneNumber) {
        if (newName != null && !newName.isEmpty()) {
            user.setName(newName);
        }
        if (newPhoneNumber != null && !newPhoneNumber.isEmpty()) {
            user.setPhoneNumber(newPhoneNumber);
        }
        users.put(user.getId(), user); // Save to "DB"
        System.out.println("Profile updated for userId=" + user.getId() +
                ", name=" + user.getName() +
                ", phone=" + user.getPhoneNumber());
    }

    public void updateUserProfile(UserUpdateRequest request) {
        User user = getUser(request.getId());
        if (request.getUserType().equals(UserType.DRIVER.name())) {
            System.out.println("For driver profile updates, please use the driver-specific endpoint.");
            updateDriverProfile((Driver) user, request.getLicence(), request.getVehicle());
        } else if (request.getUserType().equals(UserType.RIDER.name())) {
            System.out.println("Updating rider profile...");
            updateRiderProfile((Rider) user, request.getNewName(), request.getNewPhoneNumber());
        }
    }

    // Update driver-specific details
    private void updateDriverProfile(Driver driver, String licence, Vehicle vehicle) {
        if (licence != null && !licence.isEmpty()) {
            driver.setDrivingLicence(licence);
        }
        if (vehicle != null) {
            driver.setVehicleInfo(vehicle);
        }
        users.put(driver.getId(), driver); // Save to "DB"
        System.out.println("Driver profile updated for driverId=" + driver.getId() +
                ", licence=" + driver.getDrivingLicence() +
                ", vehicle=" + driver.getVehicleInfo().getBrand() +
                " " + driver.getVehicleInfo().getColor());
    }
}
