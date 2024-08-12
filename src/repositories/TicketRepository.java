package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    public Map<String, Ticket> getTicketMap() {
        return ticketMap;
    }

    public void setTicketMap(Map<String, Ticket> ticketMap) {
        this.ticketMap = ticketMap;
    }

    private Map<String, Ticket> ticketMap = new HashMap<>();

    public void save(String ticketNumber, Ticket ticket){
        ticketMap.put(ticketNumber, ticket);
    }
}
