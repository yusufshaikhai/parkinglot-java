package repositories;

import exceptions.GateNotFoundException;
import exceptions.ParkingLotNotFoundException;
import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<String, ParkingLot> parkingLotMap = new HashMap<>();

    public Map<String, ParkingLot> getParkingLotMap() {
        return parkingLotMap;
    }

    public void setParkingLotMap(Map<String, ParkingLot> parkingLotMap) {
        this.parkingLotMap = parkingLotMap;
    }

    public ParkingLot getParkingLotById(String parkingLotId) throws ParkingLotNotFoundException {
        if(parkingLotMap.containsKey(parkingLotId)){
            return parkingLotMap.get(parkingLotId);
        }
        throw new ParkingLotNotFoundException();
    }
}
