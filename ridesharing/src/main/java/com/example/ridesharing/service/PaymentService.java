package com.example.ridesharing.service;

import com.example.ridesharing.model.payment.fare.FareStrategy;
import com.example.ridesharing.model.payment.fare.NormalPriceFare;
import com.example.ridesharing.model.payment.paymentmethod.PaymentStrategy;
import com.example.ridesharing.model.payment.paymentmethod.UPI;
import com.example.ridesharing.model.payment.paymentmethod.Wallet;
import com.example.ridesharing.model.ride.Ride;

public class PaymentService {
    public void makePayment(double amount, PaymentStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Payment strategy cannot be null");
        }
        strategy.payAmount(amount);
        System.out.println("Payment of " + amount + " completed using " + strategy.getClass().getSimpleName());
    }

    public double calculateFare(Ride ride, FareStrategy fareStrategy) {
        if (fareStrategy == null) {
            throw new IllegalStateException("Fare strategy not set");
        }
        double fare = fareStrategy.calculateFare(ride);
        ride.setFare(fare);
        System.out.println("Fare calculated for rideId=" + ride.getRideId() + " is " + fare);
        return fare;
    }

    public FareStrategy getFareStrategy() {
        // For simplicity, returning a default fare strategy
        return new NormalPriceFare();
    }

    public PaymentStrategy getPaymentStrategy(String method) {
        // This method would return different payment strategies based on the method
        // For simplicity, returning null here
        if (method.equalsIgnoreCase("UPI")) {
            return new UPI();
        } else if (method.equalsIgnoreCase("Wallet")) {
            return new Wallet();
        } else {
            throw new IllegalArgumentException("Unknown payment method: " + method);
        }
    }
}
