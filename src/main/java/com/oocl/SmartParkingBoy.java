package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    //private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    private int countParkingLot;

    public SmartParkingBoy(ParkingLot... parkingLot) {
        super(parkingLot);
        //this.parkingLots = super.getParkingLots();
        countParkingLot = super.getParkingLots().size();
    }

    public ParkingTicket parkCar(Car car) {
        ParkingLot chooseParkingLot = super.getParkingLots().get(0);
        List<Integer> spaceLeftInParkingLot = new ArrayList<>();
        if (countParkingLot > 1) {
            for (ParkingLot parkingLot : super.getParkingLots()) {
                spaceLeftInParkingLot.add(parkingLot.getCapacityOfParkingLot() - parkingLot.getParkingTicketCarMap().size());
            }
            chooseParkingLot = super.getParkingLots().get(spaceLeftInParkingLot.indexOf(Collections.max(spaceLeftInParkingLot)));
        }
        return chooseParkingLot.parkCar(car);
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return super.getParkingLots().get(0).fetchCar(parkingTicket);
    }

}
