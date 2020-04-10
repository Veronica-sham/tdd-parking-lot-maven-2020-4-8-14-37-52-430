package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SuperSmartParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    private ParkingLot parkingLot;
    private int countParkingLot;

    public SuperSmartParkingBoy(ParkingLot... parkingLot) {
        this.parkingLots.addAll(Arrays.asList(parkingLot));
        countParkingLot = this.parkingLots.size();
    }

    public ParkingTicket parkCar(Car car) {
        ParkingLot chooseParkingLot = this.parkingLots.get(0);
        List<Float> availablePositionRate = new ArrayList<>();
        if (countParkingLot > 1) {
            for (ParkingLot parkingLot : this.parkingLots) {
                availablePositionRate.add((float) ((parkingLot.getCapacityOfParkingLot() - parkingLot.getParkingTicketCarMap().size())/parkingLot.getCapacityOfParkingLot()));
            }
            chooseParkingLot = this.parkingLots.get(availablePositionRate.indexOf(Collections.max(availablePositionRate)));
        }
        return chooseParkingLot.parkCar(car);
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return this.parkingLots.get(0).fetchCar(parkingTicket);
    }

}
