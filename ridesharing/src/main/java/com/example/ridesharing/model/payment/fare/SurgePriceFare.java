package com.example.ridesharing.model.payment.fare;

import com.example.ridesharing.model.ride.Ride;

public class SurgePriceFare implements FareStrategy {
    @Override
    public double calculateFare(Ride ride) {
        return 150; // base fare calculation
    }
}
