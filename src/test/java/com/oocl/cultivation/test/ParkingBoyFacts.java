package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingBoyFacts {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void should_return_1_ticket_when_parkCar_given_1_parking_boy_1_car() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car("1001");
        //When
        Ticket parkingTicket = parkingBoy.parkCar(car);
        //Then
        Assertions.assertNotNull(parkingTicket);
    }

    @Test
    void should_return_1_car_when_fetchCar_given_1_parking_boy_1_ticket() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car("1001");
        Ticket ticket = new Ticket(car);
        //When
        parkingBoy.parkCar(car);
        Car resultCar = parkingBoy.fatchCar(ticket);
        //Then
        Assertions.assertNotNull(resultCar);
    }

    @Test
    void should_return_2_ticket_when_parkCar_given_1_parking_boy_2_car() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car("1001");
        Car car2 = new Car("1002");
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        //When
        List<Ticket> parkTickets = parkingBoy.parkCar(carList);
        //Then
        assertEquals(2, parkTickets.size());
    }

    @Test
    void should_return_2_car_when_parkCar_given_1_parking_boy_2_ticket() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car("1001");
        Car car2 = new Car("1002");
        Ticket ticket1 = new Ticket(car1);
        Ticket ticket2 = new Ticket(car2);
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket1);
        ticketList.add(ticket2);
        //When
        List<Car> fetchCars = parkingBoy.fatchCar(ticketList);
        //Then
        assertEquals(2, fetchCars.size());
    }

    @Test
    void should_print_no_car_when_fetchCar_given_1_parking_boy_1_wrong_ticket() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car("1001");
        Ticket ticket = new Ticket(car);
        //When
        Car resultCar = parkingBoy.fatchCar(ticket);
        //Then
        Assertions.assertNull(resultCar);
    }

    @Test
    void should_print_no_car_when_fetchCar_given_1_parking_boy_1_used_ticket() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car("1001");
        //When
        Ticket ticket = parkingBoy.parkCar(car);
        parkingBoy.fatchCar(ticket);    //simulate the ticket has already been used.
        Car resultCar = parkingBoy.fatchCar(ticket);
        //Then
        Assertions.assertNull(resultCar);
    }

    @Test
    void should_print_parking_lot_capacity_is_full_when_parkCar_given_1_parking_boy_1_car_parking_lot_capacity_is_full() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            Car car = new Car("100" + i);
            parkingBoy.parkCar(car);
        }
        //When
        Car car = new Car("2001");
        Ticket ticket = parkingBoy.parkCar(car);
        //Then
        Assertions.assertNull(ticket);
    }

    @Test
    void should_print_unrecognized_parking_ticket_when_fetchCar_given_1_parking_boy_1_used_ticket() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car("1001");
        //When
        Ticket ticket = parkingBoy.parkCar(car);
        parkingBoy.fatchCar(ticket);    //simulate the ticket has already been used.
        Car resultCar = parkingBoy.fatchCar(ticket);
        //Then
        Assertions.assertNull(resultCar);
        Assertions.assertEquals("Unrecognized parking ticket.", outContent.toString());
    }

    @Test
    void should_print_please_provide_your_parking_ticket_when_fetchCar_given_1_parking_boy_1_wrong_ticket() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = null;
        //When
        Car resultCar = parkingBoy.fatchCar(ticket);
        //Then
        Assertions.assertNull(resultCar);
        Assertions.assertEquals("Please provide your parking ticket.", outContent.toString());
    }

    @Test
    void should_print_not_enough_position_when_parkCar_given_1_parking_boy_1_car_park_in_full_capacity_parking_lot() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            Car car = new Car("100" + i);
            parkingBoy.parkCar(car);
        }
        //When
        Car car = new Car("2001");
        Ticket ticket = parkingBoy.parkCar(car);
        //Then
        Assertions.assertNull(ticket);
        Assertions.assertEquals("Not enough position.", outContent.toString());
    }

    @Test
    void should_return_1_ticket_when_parkCar_given_1_parking_boy_2_parking_lot_1_car() {
        //Given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            Car car = new Car("100" + i);
            parkingBoy.parkCar(car);
        }
        //When
        Car car = new Car("2001");
        Ticket ticket = parkingBoy.parkCar(car);
        //Then
        Assertions.assertNotNull(ticket);
    }
}
