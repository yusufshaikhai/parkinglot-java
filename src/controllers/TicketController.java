package controllers;

import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import exceptions.GateNotFoundException;
import exceptions.ParkingLotFullException;
import exceptions.ParkingLotNotFoundException;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    public IssueTicketResponse issueTicket(IssueTicketRequest request){
        Ticket ticket = null;
        try {
            ticket = ticketService.issueTicket(request);
        } catch (GateNotFoundException e){
            System.out.println("Invalid Gate");
            return new IssueTicketResponse(null, "FAILURE", "Invalid Gate");
        } catch (ParkingLotNotFoundException e){
            System.out.println("Invalid Parking Lot");
            return new IssueTicketResponse(null, "FAILURE", "Invalid Parking Lot");
        } catch (ParkingLotFullException e) {
            System.out.println("Parking Lot is full");
            return new IssueTicketResponse(null, "FAILURE", "Parking Lot is full");
        }

        return new IssueTicketResponse(ticket, "SUCCESS", "Ticket successfully generated.");
    }
}
