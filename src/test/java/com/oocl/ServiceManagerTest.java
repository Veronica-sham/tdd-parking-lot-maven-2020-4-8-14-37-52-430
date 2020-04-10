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
    public void should_assign_a_smart_parking_boy_to_park_or_fetch_car(){
        ParkingLot secondParkingLot = new ParkingLot();

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(secondParkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = smartParkingBoy.parkCar(car);
        ParkingServiceManager serviceManager = new ParkingServiceManager(smartParkingBoy, parkingTicket);
        Car fetchedCar = serviceManager.fetchCar();
        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void should_assign_a_super_smart_parking_boy_to_park_or_fetch_car(){
        ParkingLot thirdParkingLot = new ParkingLot();

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(thirdParkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = superSmartParkingBoy.parkCar(car);
        ParkingServiceManager serviceManager = new ParkingServiceManager(superSmartParkingBoy,parkingTicket);
        Car fetchedCar = serviceManager.fetchCar();
        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void should_assign_a_normal_parking_boy_to_park_or_fetch_car(){
        ParkingLot firstParkingLot = new ParkingLot();

        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.parkCar(car);
        ParkingServiceManager serviceManager = new ParkingServiceManager(parkingBoy,parkingTicket);
        Car fetchedCar = serviceManager.fetchCar();
        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void should_return_car_when_service_manager_park_or_fetch_car(){
        ParkingLot parkingLot = new ParkingLot();
        ParkingServiceManager serviceManager = new ParkingServiceManager(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = serviceManager.parkCar(car);
        Car fetchedCarFromParkingLot = serviceManager.fetchCar(parkingTicket);
        Assert.assertEquals(car, fetchedCarFromParkingLot);
    }

    @Test
    public void should_return_exception_message_if_no_ticket_provided_for_for_service_manager(){
        expectedException.expect(MissingTicketException.class);
        expectedException.expectMessage("Please provide your parking ticket.");

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingServiceManager serviceManager = new ParkingServiceManager(parkingBoy,null);
        serviceManager.fetchCar();
    }

}
