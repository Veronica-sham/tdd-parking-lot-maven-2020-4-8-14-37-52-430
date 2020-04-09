package com.oocl;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingBoyTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_park_car_to_parking_lot(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        Car fetchedCarFromParkingLot = parkingLot.fetchCar(parkingTicket);
        Assert.assertEquals(car, fetchedCarFromParkingLot);
    }

@Test
    public void should_fetch_car_with_correct_ticket(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        Car fetchedCarFromParkingLot = parkingBoy.fetchCar(parkingTicket);
        Assert.assertEquals(car, fetchedCarFromParkingLot);
    }

    @Test
    public void should_return_exception_message_if_fetch_with_incorrect_ticket(){
        expectedException.expect(UnrecognizedParkingTicketException.class);
        expectedException.expectMessage("Unrecognized parking ticket!");

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        parkingBoy.fetchCar(new ParkingTicket());
    }



}