package com.oocl;

public class ParkingServiceManager {

    private ParkingTicket parkingTicket;
    private SmartParkingBoy smartParkingBoy;

    public ParkingServiceManager(ParkingBoy parkingBoy) {
    }

    public ParkingServiceManager(SmartParkingBoy smartParkingBoy, Car car) {
        this.smartParkingBoy = smartParkingBoy;
        this.parkingTicket = smartParkingBoy.parkCar(car);
    }

    public ParkingServiceManager(SuperSmartParkingBoy superSmartParkingBoy) {
    }


    public Car fetchCar() {
        Car car = null;
        if(!this.smartParkingBoy.equals(null)){
            car =  this.smartParkingBoy.fetchCar(this.parkingTicket);
        }

        return car;
    }
}
