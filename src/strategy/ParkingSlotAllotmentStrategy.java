package strategy;

import exceptions.ParkingLotFullException;
import exceptions.ParkingLotNotFoundException;
import models.ParkingLot;
import models.ParkingSlot;
import models.VehicleType;

public interface ParkingSlotAllotmentStrategy {

    ParkingSlot getParkingSlot(VehicleType vehicleType, ParkingLot parkingLot) throws ParkingLotFullException;
}