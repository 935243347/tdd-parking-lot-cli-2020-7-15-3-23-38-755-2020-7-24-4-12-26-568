package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @Test
    void should_return_2_ticket_when_parkCar_given_1_parking_boy_2_car() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car1 = new Car();
        Car car2 = new Car();
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        //When
        List<Ticket> parkTickets = parkingBoy.parkCar(carList);
        //Then
        assertEquals(2,parkTickets.size());
    }
    @Test
    void should_return_2_car_when_parkCar_given_1_parking_boy_2_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket1);
        ticketList.add(ticket2);
        //When
        List<Car> fetchCars = parkingBoy.fatchCar(ticketList);
        //Then
        assertEquals(2,fetchCars.size());
    }
}
