package models;

public class Vehicle {
    private VehicleType vehicleType;
    private String vehiclaNumber;
    private String ownerName;

    public Vehicle(VehicleType vehicleType, String vehiclaNumber, String ownerName) {
        this.vehicleType = vehicleType;
        this.vehiclaNumber = vehiclaNumber;
        this.ownerName = ownerName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiclaNumber() {
        return vehiclaNumber;
    }

    public void setVehiclaNumber(String vehiclaNumber) {
        this.vehiclaNumber = vehiclaNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
