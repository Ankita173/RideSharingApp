package com.example.ridesharing.model.payment.paymentmethod;

public class UPI implements PaymentStrategy {
    @Override
    public void payAmount(double amount) {
        System.out.println("Paid " + amount + " via UPI");
    }
}
