package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
   // private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    private int countParkingLot;

    public SuperSmartParkingBoy(ParkingLot... parkingLot) {
        super(parkingLot);
        //this.parkingLots = super.getParkingLots();
        countParkingLot = super.getParkingLots().size();
    }

    public ParkingTicket parkCar(Car car) {
        ParkingLot chooseParkingLot = super.getParkingLots().get(0);
        List<Float> availablePositionRate = new ArrayList<>();
        if (countParkingLot > 1) {
            for (ParkingLot parkingLot : super.getParkingLots()) {
                availablePositionRate.add((float) ((parkingLot.getCapacityOfParkingLot() - parkingLot.getParkingTicketCarMap().size())/parkingLot.getCapacityOfParkingLot()));
            }
            chooseParkingLot = super.getParkingLots().get(availablePositionRate.indexOf(Collections.max(availablePositionRate)));
        }
        return chooseParkingLot.parkCar(car);
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return super.getParkingLots().get(0).fetchCar(parkingTicket);
    }

}
