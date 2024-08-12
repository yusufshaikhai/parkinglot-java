package models;

import java.util.List;

public class ParkingLot {
    private String id;
    private List<ParkingFloor> floors;
    private List<Gate> gates;
    private VehicleType allowedVehicleType;
    private ParkingLotStatus parkingLotStatus;

    public ParkingLot(String id, List<ParkingFloor> floors, List<Gate> gates, ParkingLotStatus parkingLotStatus) {
        this.id = id;
        this.floors = floors;
        this.gates = gates;
        this.parkingLotStatus = parkingLotStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public VehicleType getAllowedVehicleType() {
        return allowedVehicleType;
    }

    public void setAllowedVehicleType(VehicleType allowedVehicleType) {
        this.allowedVehicleType = allowedVehicleType;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
}
