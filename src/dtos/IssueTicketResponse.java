package dtos;

import models.Ticket;

public class IssueTicketResponse {

    private Ticket ticket;
    private String response;
    private String message;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public IssueTicketResponse(Ticket ticket, String response, String message) {
        this.ticket = ticket;
        this.response = response;
        this.message = message;
    }
}
