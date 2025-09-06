package com.example.ridesharing.service;

import com.example.ridesharing.model.ride.driverstrategy.DriverFindingStrategy;
import com.example.ridesharing.model.ride.driverstrategy.NearestDriverStrategy;
import com.example.ridesharing.model.user.Driver;

public class DriverService {
    // Find an available driver using the strategy
    public Driver findAvailableDriver(String pickupLocation, DriverFindingStrategy driverStrategy) {
        Driver driver = driverStrategy.findNearestDriver(pickupLocation);
        if (driver == null) {
            System.out.println("No available driver near " + pickupLocation);
        } else {
            System.out.println("Driver found: " + driver.getName() + " near " + pickupLocation);
        }
        return driver;
    }

    public DriverFindingStrategy getDriverFindingStrategy() {
        return new NearestDriverStrategy();
    }
}
