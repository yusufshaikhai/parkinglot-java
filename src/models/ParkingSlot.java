package models;

public class ParkingSlot {
    private VehicleType vehicleType;
    private int slotNumber;
    private ParkingFloor floor;
    private ParkingSlotStatus parkingLotStatus;

    public ParkingSlot(VehicleType vehicleType, int slotNumber, ParkingFloor floor, ParkingSlotStatus parkingLotStatus) {
        this.vehicleType = vehicleType;
        this.slotNumber = slotNumber;
        this.floor = floor;
        this.parkingLotStatus = parkingLotStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public ParkingSlotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingSlotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
}
