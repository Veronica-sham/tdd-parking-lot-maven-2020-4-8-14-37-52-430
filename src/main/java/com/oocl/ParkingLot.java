package com.oocl;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket, Car> parkingTicketCarMap = new HashMap<ParkingTicket, Car>();
    private int capacityOfParkingLot;
    private Boolean isFull = false;

    public ParkingLot(int capcityOfParkingLot) {
        this.capacityOfParkingLot = capcityOfParkingLot;
    }

    public ParkingLot() {
        this.capacityOfParkingLot = 10;
    }

    public ParkingTicket parkCar(Car car) {
        if (this.capacityOfParkingLot == parkingTicketCarMap.size()) {
            throw new FullParkingLotException();
        }
        if (parkingTicketCarMap.containsValue(car)) {
            return null;
        }
        if (car == null) {
            return null;
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        this.parkingTicketCarMap.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        if (!this.parkingTicketCarMap.containsKey(parkingTicket) && parkingTicket != null) {
            throw new UnrecognizedParkingTicketException();
        }
        if (parkingTicket == null) {
            throw new MissingTicketException();
        }
        Car car = this.parkingTicketCarMap.remove(parkingTicket);
        return car;
    }

    public Boolean getIsFull() {
        if (this.capacityOfParkingLot == parkingTicketCarMap.size()) {
            throw new FullParkingLotException();
        }
        return isFull;
    }

    public Map<ParkingTicket, Car> getParkingTicketCarMap() {
        return parkingTicketCarMap;
    }

    public int getCapacityOfParkingLot() {
        return capacityOfParkingLot;
    }
}
