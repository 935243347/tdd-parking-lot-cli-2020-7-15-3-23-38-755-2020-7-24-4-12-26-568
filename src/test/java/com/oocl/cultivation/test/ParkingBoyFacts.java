package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingBoyFacts {
    @Test
    void should_return_1_ticket_when_parkCar_given_1_parking_boy_1_car() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        //When
        Ticket parkingTicket = parkingBoy.parkCar(car);
        //Then
        Assertions.assertNotNull(parkingTicket);
    }
    @Test
    void should_return_1_car_when_fetchCar_given_1_parking_boy_1_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket();
        //When
        Car car = parkingBoy.fatchCar(ticket);
        //Then
        Assertions.assertNotNull(car);
    }
}
