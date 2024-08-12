package models;

import java.util.Date;
import java.util.List;

public class Bill {
    private Ticket ticket;
    private List<Payment> payments;
    private Date exitTime;
    private Gate gate;
    private Operator operator;
    private int billAmount;
    private BillStatus billStatus;
}
