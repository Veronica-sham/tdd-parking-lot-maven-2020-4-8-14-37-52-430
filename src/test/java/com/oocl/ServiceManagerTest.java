package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ServiceManagerTest {

    @Test
    public void should_assign_a_smart_parking_boy_to_park_or_fetch_car(){
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();
        ParkingLot thirdParkingLot = new ParkingLot();

        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(secondParkingLot);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(thirdParkingLot);
        Car car = new Car();
        ParkingServiceManager serviceManager = new ParkingServiceManager(smartParkingBoy,car);
        Car fetchedCar = serviceManager.fetchCar();
        Assert.assertEquals(car, fetchedCar);
    }
}
