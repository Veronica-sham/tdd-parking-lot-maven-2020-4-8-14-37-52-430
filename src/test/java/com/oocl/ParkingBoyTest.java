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

    @Test
    public void should_return_exception_message_if_no_ticket_provided(){
        expectedException.expect(MissingTicketException.class);
        expectedException.expectMessage("Please provide your parking ticket.");

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        parkingBoy.fetchCar(null);
    }

    @Test
    public void should_return_exception_message_if_park_car_to_a_fulled_parking_lot(){
        expectedException.expect(FullParkingLotException.class);
        expectedException.expectMessage("Not enough position.");

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        parkingBoy.parkCar(new Car());
        parkingBoy.parkCar(car);
    }

    @Test
    public void should_park_car_to_second_parking_lot_when_first_is_full(){
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        parkingBoy.parkCar(new Car());

        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        Car fetchedCar = secondParkingLot.fetchCar(parkingTicket);
        Assert.assertEquals(car, fetchedCar);
    }


}
