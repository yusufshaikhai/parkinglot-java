package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Map<String, Vehicle> vehicleMap = new HashMap<>();

    public Map<String, Vehicle> getVehicleMap() {
        return vehicleMap;
    }

    public void setVehicleMap(Map<String, Vehicle> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public Vehicle getVehicleByVehicleNumber(String vehicleNumber){
        if(vehicleMap.containsKey(vehicleNumber)){
            return vehicleMap.get(vehicleNumber);
        }
        return null;
    }

    public void save(String vehicleNumber, Vehicle vehicle){
        vehicleMap.put(vehicleNumber, vehicle);
    }
}
