package com.example.ridesharing.controller;

import com.example.ridesharing.model.ride.Ride;
import com.example.ridesharing.model.ride.RideRequest;
import com.example.ridesharing.service.RideManagementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    private RideManagementService rideService;

    // Create Ride
    @PostMapping
    public Ride createRide(@RequestBody RideRequest request) {
        return rideService.createRide(request.getRiderId(),
                request.getPickup(),
                request.getDrop());
    }

    // Cancel Ride
    @PutMapping("/{rideId}/cancel")
    public String cancelRide(@PathVariable String rideId) {
        rideService.cancelRide(rideId);
        return "Ride " + rideId + " cancelled successfully!";
    }

    // Complete Ride
    @PutMapping("/{rideId}/complete")
    public void completeRide(@PathVariable String rideId) {
        rideService.completeRide(rideId);
    }
}
