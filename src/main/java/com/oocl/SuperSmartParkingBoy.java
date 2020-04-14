package com.oocl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {


    public SuperSmartParkingBoy(ParkingLot... parkingLot) {
        super(parkingLot);

    }

    public ParkingTicket parkCar(Car car) {
        ParkingLot chooseParkingLot;
        List<Float> availablePositionRate = new ArrayList<>();

        for (ParkingLot parkingLot : super.getParkingLots()) {
            availablePositionRate.add(parkingLot.getAvailablePositionRate());
        }
        chooseParkingLot = super.getParkingLots().get(availablePositionRate.indexOf(Collections.max(availablePositionRate)));

        return chooseParkingLot.parkCar(car);
    }

}
