package com.oocl;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {
    private Map<ParkingTicket, Car> parkingTicketCarMap = new HashMap<ParkingTicket, Car>();
    private int capacityOfParkingLot;

    public ParkingBoy(int capcityOfParkingLot){
        this.capacityOfParkingLot = capcityOfParkingLot;
    }

    public ParkingBoy(){
        this.capacityOfParkingLot =10;
    }
    public ParkingTicket parkCar(Car car){
        if(this.capacityOfParkingLot==parkingTicketCarMap.size()){
            return null;
        }
        if(parkingTicketCarMap.containsValue(car)){
            return null;
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        this.parkingTicketCarMap.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        Car car = this.parkingTicketCarMap.remove(parkingTicket);
        return car;
    }
}
