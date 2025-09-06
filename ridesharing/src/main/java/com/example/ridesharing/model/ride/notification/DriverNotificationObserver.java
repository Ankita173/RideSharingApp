package com.example.ridesharing.model.ride.notification;

import com.example.ridesharing.model.ride.Ride;
import com.example.ridesharing.model.user.Driver;

public class DriverNotificationObserver implements RideEventObserver {
    @Override
    public void onDriverAssigned(Ride ride, Driver driver) {
        System.out.println("📲 Driver " + driver.getName() +
                ": You are assigned to ride " + ride.getRideId());
    }

    @Override
    public void onNoDriverAvailable(Ride ride) {
        // Drivers don’t care about this event
    }

    @Override
    public void onRideCompleted(Ride ride) {
        System.out.println("📲 Driver " + ride.getDriverId() +
                ": Ride " + ride.getRideId() + " completed.");
    }
}
