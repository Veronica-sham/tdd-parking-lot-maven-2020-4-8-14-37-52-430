package com.oocl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    private int countParkingLot;

    public SuperSmartParkingBoy(ParkingLot... parkingLot) {
        super(parkingLot);
        countParkingLot = super.getParkingLots().size();
    }

    public ParkingTicket parkCar(Car car) {
        ParkingLot chooseParkingLot = super.getParkingLots().get(0);
        List<Float> availablePositionRate = new ArrayList<>();
        if (countParkingLot > 1) {
            for (ParkingLot parkingLot : super.getParkingLots()) {
                availablePositionRate.add(parkingLot.getAvailablePositionRate());
            }
            chooseParkingLot = super.getParkingLots().get(availablePositionRate.indexOf(Collections.max(availablePositionRate)));
        }
        return chooseParkingLot.parkCar(car);
    }


}
