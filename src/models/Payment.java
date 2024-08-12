package models;

import java.util.Date;

public class Payment {
    private String refId;
    private PaymentStatus paymentStatus;
    private Date time;
    private PaymentMode paymentMode;
    private int amount;
}
