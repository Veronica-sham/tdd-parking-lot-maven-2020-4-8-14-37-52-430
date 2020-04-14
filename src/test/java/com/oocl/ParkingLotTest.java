package com.oocl;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingLotTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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
        expectedException.expect(UnrecognizedParkingTicketException.class);
        expectedException.expectMessage("Unrecognized parking ticket!");

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.parkCar(new Car());

        parkingLot.fetchCar(new ParkingTicket());
    //    Assert.assertNull(fetchedCar);
    }

    @Test
    public void should_not_return_car_when_ticket_is_used() {
        expectedException.expect(UnrecognizedParkingTicketException.class);
        expectedException.expectMessage("Unrecognized parking ticket!");

        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.parkCar(new Car());
        parkingLot.fetchCar(parkingTicket);
        parkingLot.fetchCar(parkingTicket);
      //  Assert.assertNull(car);
    }

    @Test
    public void should_not_return_car_ticket_when_parking_lot_full() {
        expectedException.expect(FullParkingLotException.class);
        expectedException.expectMessage("Not enough position.");

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
        ParkingTicket parkingTicket1 = parkingLot.parkCar(car);
        Assert.assertNull(parkingTicket1);
    }

    @Test
    public void should_not_return_ticket_when_passing_null_car_to_parking_boy(){
        expectedException.expect(MissingTicketException.class);
        expectedException.expectMessage("Please provide your parking ticket.");

        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.parkCar(null);
        Assert.assertNull(parkingLot.fetchCar(parkingTicket));
    }






}