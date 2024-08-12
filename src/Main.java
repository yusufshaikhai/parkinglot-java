import controllers.TicketController;
import services.TicketService;
import dtos.*;
import models.*;
import repositories.*;
import strategy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Gate entryGate = new Gate(GateType.ENTRY, 1L, GateStatus.ACTIVE);
        Gate secondEntryGate = new Gate(GateType.ENTRY, 2L, GateStatus.ACTIVE);
        ParkingFloor firstFloor = new ParkingFloor(1L);
        firstFloor.getParkingSlots().add(new ParkingSlot(VehicleType.FOUR_WHEELER, 1, firstFloor,ParkingSlotStatus.EMPTY));
        firstFloor.getParkingSlots().add(new ParkingSlot(VehicleType.FOUR_WHEELER, 2, firstFloor,ParkingSlotStatus.EMPTY));
        firstFloor.getParkingSlots().add(new ParkingSlot(VehicleType.TWO_WHEELER, 3, firstFloor,ParkingSlotStatus.EMPTY));
        firstFloor.getParkingSlots().add(new ParkingSlot(VehicleType.THREE_WHEELER, 4, firstFloor,ParkingSlotStatus.EMPTY));

        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(firstFloor);
        List<Gate> gates = new ArrayList<>();
        gates.add(entryGate);
        gates.add(secondEntryGate);

        ParkingLot parkingLot = new ParkingLot(UUID.randomUUID().toString(), floors, gates, ParkingLotStatus.ACTIVE);


        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();

        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, ticketRepository, parkingLotRepository);
        TicketController ticketController = new TicketController(ticketService);

        parkingLotRepository.getParkingLotMap().put(parkingLot.getId(), parkingLot);
        gateRepository.getGateMap().put(entryGate.getGateNumber(), entryGate);
        gateRepository.getGateMap().put(secondEntryGate.getGateNumber(), secondEntryGate);


        ParkingSlotAllotmentStrategy allotmentStrategy = new SimpleParkingAllotmentStrategy();

        IssueTicketRequest request = new IssueTicketRequest(
                secondEntryGate.getGateNumber(), parkingLot.getId(), "MH01AN1232", "Yusuf", VehicleType.FOUR_WHEELER, allotmentStrategy
        );

        IssueTicketResponse issueTicketResponse = ticketController.issueTicket(request);

        System.out.println(issueTicketResponse.getTicket());
        System.out.println(issueTicketResponse.getResponse());
        System.out.println(issueTicketResponse.getMessage());

    }
}