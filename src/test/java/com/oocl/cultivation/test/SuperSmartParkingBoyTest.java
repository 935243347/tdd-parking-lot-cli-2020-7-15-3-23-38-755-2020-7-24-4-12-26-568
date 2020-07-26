package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void should_return_2_ticket_when_parkCar_given_1_super_smart_parking_boy_2_car_1_parking_lot() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car1 = new Car("1001");
        Car car2 = new Car("1002");
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        //When
        List<Ticket> parkTickets = superSmartParkingBoy.parkCar(carList);
        //Then
        assertEquals(2, parkTickets.size());
    }

    @Test
    void should_return_2_car_when_parkCar_given_1_super_smart_parking_boy_2_ticket_1_parking_lot() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car1 = new Car("1001");
        Car car2 = new Car("1002");
        Ticket ticket1 = new Ticket(car1);
        Ticket ticket2 = new Ticket(car2);
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket1);
        ticketList.add(ticket2);
        //When
        List<Car> fetchCars = superSmartParkingBoy.fatchCar(ticketList);
        //Then
        assertEquals(2, fetchCars.size());
    }

    @Test
    void should_print_no_car_when_fetchCar_given_1_super_smart_parking_boy_1_wrong_ticket_1_parking_lot() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car("1001");
        Ticket ticket = new Ticket(car);
        //When
        Car resultCar = superSmartParkingBoy.fatchCar(ticket);
        //Then
        Assertions.assertNull(resultCar);
    }

    @Test
    void should_print_no_car_when_fetchCar_given_1_super_smart_parking_boy_1_used_ticket_1_parking_lot() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car = new Car("1001");
        //When
        Ticket ticket = superSmartParkingBoy.parkCar(car);
        superSmartParkingBoy.fatchCar(ticket);    //simulate the ticket has already been used.
        Car resultCar = superSmartParkingBoy.fatchCar(ticket);
        //Then
        Assertions.assertNull(resultCar);
    }

    @Test
    void should_print_parking_lot_capacity_is_full_when_parkCar_given_1_super_smart_parking_boy_1_car_parking_lot_capacity_is_full() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            Car car = new Car("100" + i);
            superSmartParkingBoy.parkCar(car);
        }
        //When
        Car car = new Car("2001");
        Ticket ticket = superSmartParkingBoy.parkCar(car);
        //Then
        Assertions.assertNull(ticket);
    }
}
