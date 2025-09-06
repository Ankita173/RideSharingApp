package com.example.ridesharing.model.payment.fare;

import com.example.ridesharing.model.ride.Ride;

public interface FareStrategy {
    double calculateFare(Ride ride);
}
