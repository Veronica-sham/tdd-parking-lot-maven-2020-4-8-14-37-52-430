package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class SuperSmartParkingBoyTest {

    @Test
    public void should_park_car_to_parking_lot_with_larger_available_position_rate(){
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(7);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(firstParkingLot, secondParkingLot);
        superSmartParkingBoy.parkCar(new Car());
        Car car = new Car();
        ParkingTicket parkingTicket = superSmartParkingBoy.parkCar(car);
        Car fetchedCar = secondParkingLot.fetchCar(parkingTicket);
        Assert.assertEquals(car, fetchedCar);
    }
}
