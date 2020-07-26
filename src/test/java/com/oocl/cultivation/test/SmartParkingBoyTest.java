package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {
    @Test
    void should_return_1_ticket_when_parkCar_given_1_smart_parking_boy_1_car_1_parking_lot() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car("1001");
        //When
        Ticket parkingTicket = smartParkingBoy.parkCar(car);
        //Then
        Assertions.assertNotNull(parkingTicket);
    }

    @Test
    void should_return_1_car_when_fetchCar_given_1_smart_parking_boy_1_ticket_1_parking_lot() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car("1001");
        Ticket ticket = new Ticket(car);
        //When
        smartParkingBoy.parkCar(car);
        Car resultCar = smartParkingBoy.fatchCar(ticket);
        //Then
        Assertions.assertNotNull(resultCar);
    }
}
