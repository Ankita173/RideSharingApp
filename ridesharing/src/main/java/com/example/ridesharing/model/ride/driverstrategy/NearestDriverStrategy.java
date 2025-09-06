package com.example.ridesharing.model.ride.driverstrategy;

import com.example.ridesharing.model.user.Driver;

public class NearestDriverStrategy implements DriverFindingStrategy {
    @Override
    public Driver findNearestDriver(String pickupLocation) {
        // mock implementation
        return new Driver();
    }
}
