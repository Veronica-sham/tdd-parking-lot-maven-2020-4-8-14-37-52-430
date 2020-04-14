package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    public ParkingBoy(ParkingLot... parkingLot) {
        this.parkingLots.addAll(Arrays.asList(parkingLot));
    }

    public ParkingTicket parkCar(Car car) {
        ParkingLot chooseParkingLot = this.parkingLots.stream().filter(parkingLots -> !parkingLots.getIsFull()).findFirst().orElseThrow(FullParkingLotException::new);
        return chooseParkingLot.parkCar(car);
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return this.parkingLots.get(0).fetchCar(parkingTicket);
    }

    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }

    public boolean containCar(Car car) {
        return getParkingLots().stream().anyMatch(parkingLot -> parkingLot.getParkingTicketCarMap().containsValue(car));
    }
}
