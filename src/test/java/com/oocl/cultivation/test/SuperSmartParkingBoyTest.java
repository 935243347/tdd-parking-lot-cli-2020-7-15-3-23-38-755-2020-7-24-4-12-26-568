package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperSmartParkingBoyTest {
    @Test
    void should_return_1_ticket_when_parkCar_given_1_super_smart_parking_boy_1_car_1_parking_lot() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car("1001");
        //When
        Ticket parkingTicket = superSmartParkingBoy.parkCar(car);
        //Then
        Assertions.assertNotNull(parkingTicket);
    }

    @Test
    void should_return_1_car_when_fetchCar_given_1_super_smart_parking_boy_1_ticket_1_parking_lot() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car("1001");
        Ticket ticket = new Ticket(car);
        //When
        superSmartParkingBoy.parkCar(car);
        Car resultCar = superSmartParkingBoy.fatchCar(ticket);
        //Then
        Assertions.assertNotNull(resultCar);
    }
}
