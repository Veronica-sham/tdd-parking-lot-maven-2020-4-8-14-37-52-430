package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void should_return_ticket_when_parking_boy_park_car() {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingTicket parkingTicket = parkingBoy.parkCar(new Car());
        Assert.assertNotNull(parkingTicket);
    }

    @Test
    public void should_fetch_car_when_parking_ticket_return_to_parking_boy() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        Car fetchedCar = parkingBoy.fetchCar(parkingTicket);

        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void should_not_return_car_when_wrong_parking_ticket_return_to_parking_boy() {
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.parkCar(new Car());

        Car fetchedCar = parkingBoy.fetchCar(new ParkingTicket());
        Assert.assertNull(fetchedCar);
    }

    @Test
    public void should_not_return_car_when_ticket_is_used() {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingTicket parkingTicket = parkingBoy.parkCar(new Car());
        parkingBoy.fetchCar(parkingTicket);
        Car car = parkingBoy.fetchCar(parkingTicket);
        Assert.assertNull(car);
    }

    @Test
    public void should_not_return_car_ticket_when_parking_lot_full() {
        ParkingBoy parkingBoy = new ParkingBoy(1);
        parkingBoy.parkCar(new Car());
        ParkingTicket parkingTicket = parkingBoy.parkCar(new Car());

        Assert.assertNull(parkingTicket);
    }

    @Test
    public void should_not_return_ticket_when_passing_a_parked_car_to_parking_boy(){
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        Car fetchedCar = parkingBoy.fetchCar(parkingTicket);
        Assert.assertNull(parkingBoy.fetchCar(parkingTicket));
    }

    @Test
    public void should_not_return_ticket_when_passing_null_car_to_parking_boy(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingTicket parkingTicket = parkingBoy.parkCar(null);
        Assert.assertNull(parkingBoy.fetchCar(parkingTicket));
    }




}