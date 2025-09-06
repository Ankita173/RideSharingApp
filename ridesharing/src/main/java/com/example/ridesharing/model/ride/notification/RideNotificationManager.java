package com.example.ridesharing.model.ride.notification;

import com.example.ridesharing.model.ride.Ride;
import com.example.ridesharing.model.user.Driver;

import java.util.ArrayList;
import java.util.List;

public class RideNotificationManager {
    private final List<RideEventObserver> observers = new ArrayList<>();

    public void addObserver(RideEventObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(RideEventObserver observer) {
        observers.remove(observer);
    }

    public void notifyDriverAssigned(Ride ride, Driver driver) {
        for (RideEventObserver observer : observers) {
            observer.onDriverAssigned(ride, driver);
        }
    }

    public void notifyNoDriverAvailable(Ride ride) {
        for (RideEventObserver observer : observers) {
            observer.onNoDriverAvailable(ride);
        }
    }

    public void notifyRideCompleted(Ride ride) {
        for (RideEventObserver observer : observers) {
            observer.onRideCompleted(ride);
        }
    }
}
