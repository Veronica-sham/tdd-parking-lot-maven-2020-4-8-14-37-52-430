package com.oocl;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.jnlp.ServiceManager;
import javax.xml.ws.Service;

public class ServiceManagerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_assign_a_smart_parking_boy_to_park_or_fetch_car() {
        ParkingLot secondParkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(secondParkingLot);
        ParkingServiceManager manager = new ParkingServiceManager();
        manager.addParkingBoys(smartParkingBoy);
        Car car = new Car();
        ParkingTicket parkingTicket = manager.parkCarByAnyParkingBoy(car);
        Car fetchedCar = manager.fetchCarByAnyParkingBoy(parkingTicket);
        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void should_assign_a_super_smart_parking_boy_to_park_or_fetch_car() {
        ParkingLot thirdParkingLot = new ParkingLot();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(thirdParkingLot);
        ParkingServiceManager manager = new ParkingServiceManager();
        manager.addParkingBoys(superSmartParkingBoy);
        Car car = new Car();
        ParkingTicket parkingTicket = manager.parkCarByAnyParkingBoy(car);
        Car fetchedCar = manager.fetchCarByAnyParkingBoy(parkingTicket);
        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void should_assign_a_normal_parking_boy_to_park_or_fetch_car() {
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot);
        ParkingServiceManager manager = new ParkingServiceManager();
        manager.addParkingBoys(parkingBoy);
        Car car = new Car();
        ParkingTicket parkingTicket = manager.parkCarByAnyParkingBoy(car);
        Car fetchedCar = manager.fetchCarByAnyParkingBoy(parkingTicket);
        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void should_return_car_when_service_manager_park_or_fetch_car() {
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingServiceManager manager = new ParkingServiceManager(firstParkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = manager.parkCar(car);
        Car fetchedCar = manager.fetchCar(parkingTicket);
        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void should_return_exception_message_if_no_ticket_provided_for_service_manager() {
        expectedException.expect(MissingTicketException.class);
        expectedException.expectMessage("Please provide your parking ticket.");

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingServiceManager serviceManager = new ParkingServiceManager();
        serviceManager.addParkingBoys(parkingBoy);
        serviceManager.parkCarByAnyParkingBoy(car);
        serviceManager.fetchCarByAnyParkingBoy(null);
    }

    @Test
    public void should_return_exception_message_if_park_car_to_a_fulled_parking_lot_for_service_manager() {
        expectedException.expect(FullParkingLotException.class);
        expectedException.expectMessage("Not enough position.");

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingServiceManager serviceManager = new ParkingServiceManager();
        serviceManager.addParkingBoys(parkingBoy);
        serviceManager.parkCarByAnyParkingBoy(car);
        serviceManager.parkCarByAnyParkingBoy(new Car());

    }

    @Test
    public void should_return_exception_message_if_fetch_with_incorrect_ticket_for_service_manager() {
        expectedException.expect(UnrecognizedParkingTicketException.class);
        expectedException.expectMessage("Unrecognized parking ticket!");

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingServiceManager serviceManager = new ParkingServiceManager();
        serviceManager.addParkingBoys(parkingBoy);
        serviceManager.parkCarByAnyParkingBoy(car);
        serviceManager.fetchCarByAnyParkingBoy(new ParkingTicket());
    }

    @Test
    public void should_not_return_ticket_when_no_car_is_parked() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingServiceManager serviceManager = new ParkingServiceManager();
        serviceManager.addParkingBoys(parkingBoy);
        ParkingTicket parkingTicket = serviceManager.parkCarByAnyParkingBoy(null);
        Assert.assertEquals(null,parkingTicket);
    }

    @Test
    public void should_not_return_ticket_when_the_car_has_been_parked_already() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingServiceManager serviceManager = new ParkingServiceManager();
        serviceManager.addParkingBoys(parkingBoy);
        serviceManager.parkCarByAnyParkingBoy(car);
        ParkingTicket parkingTicket1 = serviceManager.parkCarByAnyParkingBoy(car);
        Assert.assertEquals(null,parkingTicket1);
    }
}
