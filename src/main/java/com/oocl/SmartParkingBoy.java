package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmartParkingBoy {

    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    private ParkingLot parkingLot;
    private int countParkingLot;

    public SmartParkingBoy(ParkingLot... parkingLot){
        this.parkingLots.addAll(Arrays.asList(parkingLot));
        countParkingLot = this.parkingLots.size();
    }

    public ParkingTicket parkCar(Car car) {
        ParkingLot chooseParkingLot = this.parkingLots.get(0);
        List<Integer> spaceLeftInParkingLot = new ArrayList<>();
        if(countParkingLot>1){
            for(ParkingLot parkingLot:this.parkingLots){
               spaceLeftInParkingLot.add(parkingLot.getCapacityOfParkingLot() - parkingLot.getParkingTicketCarMap().size());
            }
            chooseParkingLot = this.parkingLots.get(spaceLeftInParkingLot.indexOf(Collections.max(spaceLeftInParkingLot)));
        }
        return chooseParkingLot.parkCar(car);
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return this.parkingLots.get(0).fetchCar(parkingTicket);
    }

}
