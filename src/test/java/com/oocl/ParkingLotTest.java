package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    @Test
    public void should_return_ticket_when_parking_boy_park_car(){
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingTicket parkingTicket = parkingBoy.parkCar(new Car());
        Assert.assertNotNull(parkingTicket);
    }
}
