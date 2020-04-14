package com.oocl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {


    public SmartParkingBoy(ParkingLot... parkingLot) {
        super(parkingLot);
    }

    public ParkingTicket parkCar(Car car) {
        ParkingLot chooseParkingLot;
        List<Integer> spaceLeftInParkingLot = new ArrayList<>();
        for (ParkingLot parkingLot : super.getParkingLots()) {
            spaceLeftInParkingLot.add(parkingLot.getSpaceLeftInParkingLot());
        }
        chooseParkingLot = super.getParkingLots().get(spaceLeftInParkingLot.indexOf(Collections.max(spaceLeftInParkingLot)));

        return chooseParkingLot.parkCar(car);
    }

}
