package com.example.ridesharing.model.ride.notification;

import com.example.ridesharing.model.ride.Ride;
import com.example.ridesharing.model.user.Driver;

public class RiderNotificationObserver implements RideEventObserver {
    @Override
    public void onDriverAssigned(Ride ride, Driver driver) {
        System.out.println("📲 Rider " + ride.getRiderId() +
                ": Driver " + driver.getName() + " assigned for your ride " + ride.getRideId());
    }

    @Override
    public void onNoDriverAvailable(Ride ride) {
        System.out.println("📲 Rider " + ride.getRiderId() +
                ": Sorry, no driver available for ride " + ride.getRideId());
    }

    @Override
    public void onRideCompleted(Ride ride) {
        System.out.println("📲 Rider " + ride.getRiderId() +
                ": Ride " + ride.getRideId() + " completed. Fare = " + ride.getFare());
    }
}
