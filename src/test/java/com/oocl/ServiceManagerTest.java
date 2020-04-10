package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ServiceManagerTest {

    @Test
    public void should_assign_a_smart_parking_boy_to_park_or_fetch_car(){
        ParkingLot secondParkingLot = new ParkingLot();

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(secondParkingLot);
        Car car = new Car();
        ParkingServiceManager serviceManager = new ParkingServiceManager(smartParkingBoy,car);
        Car fetchedCar = serviceManager.fetchCar();
        Assert.assertEquals(car, fetchedCar);
    }

    @Test
    public void should_assign_a_super_smart_parking_boy_to_park_or_fetch_car(){
        ParkingLot thirdParkingLot = new ParkingLot();

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(thirdParkingLot);
        Car car = new Car();
        ParkingServiceManager serviceManager = new ParkingServiceManager(superSmartParkingBoy,car);
        Car fetchedCar = serviceManager.fetchCar();
        Assert.assertEquals(car, fetchedCar);
    }
    @Test
    public void should_assign_a_normal_parking_boy_to_park_or_fetch_car(){
        ParkingLot firstParkingLot = new ParkingLot();

        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot);
        Car car = new Car();
        ParkingServiceManager serviceManager = new ParkingServiceManager(parkingBoy,car);
        Car fetchedCar = serviceManager.fetchCar();
        Assert.assertEquals(car, fetchedCar);
    }
}
