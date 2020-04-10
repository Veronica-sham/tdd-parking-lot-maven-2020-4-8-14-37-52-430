package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot... parkingLot){
        this.parkingLots.addAll(Arrays.asList(parkingLot));
    }

    public ParkingTicket parkCar(Car car) {
        ParkingLot chooseParkingLot = this.parkingLots.stream().filter(parkingLots ->!parkingLots.getIsFull()).findFirst().get();
        return chooseParkingLot.parkCar(car);
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return this.parkingLots.get(0).fetchCar(parkingTicket);
    }

    public int getCountParkingLog(){
        return this.parkingLots.size();
    }

}
