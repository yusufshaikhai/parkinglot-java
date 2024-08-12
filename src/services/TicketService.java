package services;

import dtos.IssueTicketRequest;
import exceptions.GateNotFoundException;
import exceptions.ParkingLotFullException;
import exceptions.ParkingLotNotFoundException;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategy.ParkingSlotAllotmentStrategy;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket issueTicket(IssueTicketRequest request) throws GateNotFoundException, ParkingLotNotFoundException, ParkingLotFullException {
        /*
            Set entry time
            get vehicle & gate
            create ticket
        */
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Gate gate = gateRepository.getGateById(request.getGateId());
        ticket.setGate(gate);

        Vehicle vehicle = vehicleRepository.getVehicleByVehicleNumber(request.getVehicleNumber());
        if(vehicle == null){
            vehicle = new Vehicle(request.getVehicleType(), request.getVehicleNumber(), request.getVehicleOwnerName());
            vehicleRepository.save(request.getVehicleNumber(), vehicle);
        }

        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(request.getParkingLotId());

        ParkingSlotAllotmentStrategy allotmentStrategy = request.getParkingPlaceAllotmentStrategy();
        ParkingSlot parkingSlot = allotmentStrategy.getParkingSlot(request.getVehicleType(), parkingLot);

        ticket.setParkingSlot(parkingSlot);
        ticket.setVehicle(vehicle);
        ticket.setNumber(request.getVehicleNumber().toLowerCase() + "-" + UUID.randomUUID());

        ticketRepository.save(ticket.getNumber(), ticket);

        return ticket;
    }
}
