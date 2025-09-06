package com.example.ridesharing.model.ride.driverstrategy;

import com.example.ridesharing.model.user.Driver;

public interface DriverFindingStrategy {
    Driver findNearestDriver(String pickupLocation);
}
