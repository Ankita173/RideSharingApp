package com.example.ridesharing.model.payment.fare;

import com.example.ridesharing.model.ride.Ride;

public class NormalPriceFare implements FareStrategy {
    @Override
    public double calculateFare(Ride ride) {
        return 100; // base fare calculation
    }
}
