package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public Ticket parkCar(Car car) {
        Ticket ticket = parkingLot.packCar(car);
        return ticket;
    }

    public Car fatchCar(Ticket ticket) {
        Car car = parkingLot.fatchCar(ticket);
        return car;
    }
    public List<Ticket> parkCar(List<Car> carList) {
        ArrayList<Ticket> ticketList = new ArrayList<>();
        for(Car car : carList){
            ticketList.add(new Ticket(car));
        }
        return ticketList;
    }

    public List<Car> fatchCar(List<Ticket> ticketList) {
        ArrayList<Car> carList = new ArrayList<>();
        for(Ticket ticket : ticketList){
            carList.add(new Car(ticket.getCar().getEnginId()));
        }
        return carList;
    }
}
