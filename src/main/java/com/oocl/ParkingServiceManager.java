package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingServiceManager extends ParkingBoy {

    private List<ParkingBoy> parkingBoys = new ArrayList<>();

    public ParkingServiceManager(ParkingLot... parkingLot) {
        super(parkingLot);
    }

    public void addParkingBoys(ParkingBoy... parkingBoys) {
        this.parkingBoys.addAll(Arrays.asList(parkingBoys));
    }

    public ParkingTicket parkCarByAnyParkingBoy(Car car) {
        if (car == null) {
            return null;
        }
        if (parkingBoys.stream().anyMatch(parkingBoy -> parkingBoy.containCar(car))) {
            return null;
        }

        ParkingTicket parkingTicket = parkingBoys.stream().map(ParkingBoy -> ParkingBoy.parkCar(car)).findFirst().orElseThrow(FullParkingLotException::new);
        return parkingTicket;
    }


    public Car fetchCarByAnyParkingBoy(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new MissingTicketException();
        }
        Car car = parkingBoys.stream().map(parkingBoy -> parkingBoy.fetchCar(parkingTicket)).findFirst()
                .orElseThrow(UnrecognizedParkingTicketException::new);
        return car;
    }

}

