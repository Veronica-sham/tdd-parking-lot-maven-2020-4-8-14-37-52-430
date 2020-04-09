package com.oocl;

public class MissingTicketException extends RuntimeException {
    public MissingTicketException(){
        super("Please provide your parking ticket.");
    }
}
