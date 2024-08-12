package repositories;

import exceptions.GateNotFoundException;
import models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private Map<Long, Gate> gateMap = new HashMap<>();

    public Map<Long, Gate> getGateMap() {
        return gateMap;
    }

    public void setGateMap(Map<Long, Gate> gateMap) {
        this.gateMap = gateMap;
    }

    public Gate getGateById(Long gateId) throws GateNotFoundException {
        if(gateMap.containsKey(gateId)){
            return gateMap.get(gateId);
        }
        throw new GateNotFoundException();
    }
}
