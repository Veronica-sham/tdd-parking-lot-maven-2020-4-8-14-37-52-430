package com.oocl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingServiceManager {

    private ParkingTicket parkingTicket;
    private SmartParkingBoy smartParkingBoy = null;
    private SuperSmartParkingBoy superSmartParkingBoy = null;
    private ParkingBoy parkingBoy = null;
    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    private ParkingLot parkingLot;

    public ParkingServiceManager(ParkingLot... parkingLot){
        this.parkingLots.addAll(Arrays.asList(parkingLot));
    }

    public ParkingTicket parkCar(Car car) {
        ParkingLot chooseParkingLot = this.parkingLots.stream().filter(parkingLots ->!parkingLots.getIsFull()).findFirst().get();
        return chooseParkingLot.parkCar(car);
    }

    public ParkingServiceManager(ParkingBoy parkingBoy, ParkingTicket parkingTicket) {
        this.parkingBoy = parkingBoy;
        this.parkingTicket = parkingTicket;
    }

    public ParkingServiceManager(SmartParkingBoy smartParkingBoy, ParkingTicket parkingTicket) {
        this.smartParkingBoy = smartParkingBoy;
        this.parkingTicket = parkingTicket;
    }

    public ParkingServiceManager(SuperSmartParkingBoy superSmartParkingBoy, ParkingTicket parkingTicket) {
        this.superSmartParkingBoy = superSmartParkingBoy;
        this.parkingTicket = parkingTicket;
    }


    public Car fetchCar() {
        Car car = null;

        if (this.smartParkingBoy!=null) {
            car = this.smartParkingBoy.fetchCar(this.parkingTicket);
        }
        if (this.superSmartParkingBoy!=(null)) {
            car = this.superSmartParkingBoy.fetchCar(this.parkingTicket);
        }
        if (this.parkingBoy!=(null)) {
            car = this.parkingBoy.fetchCar(this.parkingTicket);
        }

            return car;
        }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return this.parkingLots.get(0).fetchCar(parkingTicket);
    }

}

