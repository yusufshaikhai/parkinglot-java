package strategy;

import exceptions.ParkingLotFullException;
import exceptions.ParkingLotNotFoundException;
import models.*;
import repositories.ParkingLotRepository;

public class SimpleParkingAllotmentStrategy implements ParkingSlotAllotmentStrategy {
    private ParkingLotRepository parkingLotRepository;

    @Override
    public ParkingSlot getParkingSlot(VehicleType vehicleType, ParkingLot parkingLot) throws ParkingLotFullException {
        for(ParkingFloor floor: parkingLot.getFloors()){
            for(ParkingSlot parkingSlot: floor.getParkingSlots()){
                if(parkingSlot.getParkingLotStatus().equals(ParkingSlotStatus.EMPTY)) {
                    if(parkingSlot.getVehicleType().equals(vehicleType)){
                        return parkingSlot;
                    }
                }
            }
        }
        throw new ParkingLotFullException();
    }
}
