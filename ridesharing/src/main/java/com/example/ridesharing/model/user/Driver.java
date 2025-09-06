package com.example.ridesharing.model.user;

public class Driver extends User {
    private String drivingLicence;
    private Vehicle vehicleInfo;

    public Driver(String id, String name, String phoneNumber) {
        super();
    }

    public Driver() {

    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public Vehicle getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(Vehicle vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }
// getters/setters
}
