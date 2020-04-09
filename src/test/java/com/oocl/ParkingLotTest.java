package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void should_return_ticket_when_parking_boy_park_car() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.parkCar(new Car());
        Assert.assertNotNull(parkingTicket);
    }

    @Test
    public void should_fetch_car_when_parking_ticket_return_to_parking_boy() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.parkCar(car);
        Car fetchedCar = parkingLot.fetchCar(parkingTicket);

        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void should_not_return_car_when_wrong_parking_ticket_return_to_parking_boy() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.parkCar(new Car());

        Car fetchedCar = parkingLot.fetchCar(new ParkingTicket());
        Assert.assertNull(fetchedCar);
    }

    @Test
    public void should_not_return_car_when_ticket_is_used() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.parkCar(new Car());
        parkingLot.fetchCar(parkingTicket);
        Car car = parkingLot.fetchCar(parkingTicket);
        Assert.assertNull(car);
    }

    @Test
    public void should_not_return_car_ticket_when_parking_lot_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parkCar(new Car());
        ParkingTicket parkingTicket = parkingLot.parkCar(new Car());

        Assert.assertNull(parkingTicket);
    }

    @Test
    public void should_not_return_ticket_when_passing_a_parked_car_to_parking_boy(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.parkCar(car);
        Car fetchedCar = parkingLot.fetchCar(parkingTicket);
        Assert.assertNull(parkingLot.fetchCar(parkingTicket));
    }

    @Test
    public void should_not_return_ticket_when_passing_null_car_to_parking_boy(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.parkCar(null);
        Assert.assertNull(parkingLot.fetchCar(parkingTicket));
    }






}