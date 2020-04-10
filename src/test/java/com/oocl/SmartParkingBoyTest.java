package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class SmartParkingBoyTest {



    @Test
    public void should_park_car_to_parking_lot_with_more_positions(){
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(7);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(firstParkingLot, secondParkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = smartParkingBoy.parkCar(car);
        Car fetchedCar = secondParkingLot.fetchCar(parkingTicket);
        Assert.assertEquals(car, fetchedCar);
    }
}
