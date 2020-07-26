package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public Ticket parkCar(Car car) {
        return parkingLot.packCar(car);
    }

    public Car fatchCar(Ticket ticket) {
        return parkingLot.fatchCar(ticket);
    }

    public List<Ticket> parkCar(List<Car> carList) {
        ArrayList<Ticket> ticketList = new ArrayList<>();
        Ticket ticket = null;
        for (Car car : carList) {
            ticket = parkingLot.packCar(car);
            ticketList.add(ticket);
        }
        return ticketList;
    }

    public List<Car> fatchCar(List<Ticket> ticketList) {
        ArrayList<Car> carList = new ArrayList<>();
        Car car = null;
        for (Ticket ticket : ticketList) {
            car = parkingLot.fatchCar(ticket);
            carList.add(car);
        }
        return carList;
    }
}
