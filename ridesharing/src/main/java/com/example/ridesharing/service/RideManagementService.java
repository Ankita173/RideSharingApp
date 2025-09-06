package com.example.ridesharing.service;

import com.example.ridesharing.model.ride.Ride;
import com.example.ridesharing.model.ride.RideStatus;
import com.example.ridesharing.model.ride.notification.RideNotificationManager;
import com.example.ridesharing.model.ride.notification.RiderNotificationObserver;
import com.example.ridesharing.model.user.Driver;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RideManagementService  {
    private DriverService driverService;
    private PaymentService paymentService;
    private RideNotificationManager notificationManager;

    Map<String, Ride> rides = new HashMap<>();

    public Ride createRide(String riderId, String pickup, String drop) {
        Ride ride = new Ride();
        ride.setRideId("R" + System.currentTimeMillis());
        ride.setRiderId(riderId);
        ride.setPickupLocation(pickup);
        ride.setDropLocation(drop);
        ride.setStatus(RideStatus.REQUESTED);
        notificationManager.addObserver(new RiderNotificationObserver());
        Driver driver = driverService.findAvailableDriver(pickup, driverService.getDriverFindingStrategy());

        if (driver == null) {
            notificationManager.notifyNoDriverAvailable(ride);
        } else {
            ride.setDriverId(driver.getId());
            ride.setStatus(RideStatus.ACCEPTED);
            notificationManager.notifyDriverAssigned(ride, driver);
        }
        rides.put(ride.getRideId(), ride);
        return ride;
    }

    public void completeRide(String rideId) {
        Ride ride = rides.get(rideId);
        double fare = paymentService.calculateFare(ride, paymentService.getFareStrategy());
        ride.setFare(fare);
        ride.setStatus(RideStatus.COMPLETED);
        paymentService.makePayment(fare, paymentService.getPaymentStrategy("UPI"));
        notificationManager.notifyRideCompleted(ride);
        rides.put(ride.getRideId(), ride);
    }

    public void cancelRide(String rideId) {
        Ride ride = rides.get(rideId);
        ride.setStatus(RideStatus.CANCELLED);
        notificationManager.removeObserver(new RiderNotificationObserver());
        System.out.println("Ride cancelled: rideId=" + ride.getRideId());
        rides.put(ride.getRideId(), ride);
    }
}
