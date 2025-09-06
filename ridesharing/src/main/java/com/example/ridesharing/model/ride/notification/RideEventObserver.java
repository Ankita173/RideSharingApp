package com.example.ridesharing.model.ride.notification;

import com.example.ridesharing.model.ride.Ride;
import com.example.ridesharing.model.user.Driver;
import com.example.ridesharing.model.user.User;

public interface RideEventObserver {
    void onDriverAssigned(Ride ride, Driver driver);
    void onNoDriverAvailable(Ride ride);
    void onRideCompleted(Ride ride);
}
