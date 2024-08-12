package dtos;

import models.VehicleType;
import strategy.ParkingSlotAllotmentStrategy;

public class IssueTicketRequest {
    private Long gateId;
    private String parkingLotId;
    private String vehicleNumber;
    private String vehicleOwnerName;
    private VehicleType vehicleType;
    private ParkingSlotAllotmentStrategy parkingPlaceAllotmentStrategy;

    public IssueTicketRequest(Long gateId, String parkingLotId, String vehicleNumber, String vehicleOwnerName, VehicleType vehicleType, ParkingSlotAllotmentStrategy parkingPlaceAllotmentStrategy) {
        this.gateId = gateId;
        this.parkingLotId = parkingLotId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleOwnerName = vehicleOwnerName;
        this.vehicleType = vehicleType;
        this.parkingPlaceAllotmentStrategy = parkingPlaceAllotmentStrategy;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSlotAllotmentStrategy getParkingPlaceAllotmentStrategy() {
        return parkingPlaceAllotmentStrategy;
    }

    public void setParkingPlaceAllotmentStrategy(ParkingSlotAllotmentStrategy parkingPlaceAllotmentStrategy) {
        this.parkingPlaceAllotmentStrategy = parkingPlaceAllotmentStrategy;
    }
}
