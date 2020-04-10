package com.oocl;

public class ParkingServiceManager {

    private ParkingTicket parkingTicket;
    private SmartParkingBoy smartParkingBoy = null;
    private SuperSmartParkingBoy superSmartParkingBoy = null;
    private ParkingBoy parkingBoy = null;

    public ParkingServiceManager(ParkingBoy parkingBoy, Car car) {
        this.parkingBoy = parkingBoy;
        this.parkingTicket = parkingBoy.parkCar(car);
    }

    public ParkingServiceManager(SmartParkingBoy smartParkingBoy, Car car) {
        this.smartParkingBoy = smartParkingBoy;
        this.parkingTicket = smartParkingBoy.parkCar(car);
    }

    public ParkingServiceManager(SuperSmartParkingBoy superSmartParkingBoy, Car car) {
        this.superSmartParkingBoy = superSmartParkingBoy;
        this.parkingTicket = superSmartParkingBoy.parkCar(car);
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
            car = this.parkingBoy.fetchCar(this.parkingTicket);}

            return car;
        }
    }

