package com.oocl;

public class FullParkingLotException extends RuntimeException{
    public FullParkingLotException(){
        super("Not enough position.");
    }
}
