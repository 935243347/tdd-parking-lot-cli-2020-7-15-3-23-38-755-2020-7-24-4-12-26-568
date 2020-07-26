package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.packCar(car);
        }
        return null;
    }

    public Car fatchCar(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.fatchCar(ticket);
        }
        return null;
    }

    public List<Ticket> parkCar(List<Car> carList) {
        ArrayList<Ticket> ticketList = new ArrayList<>();
        Ticket ticket = null;
        for (Car car : carList) {
            for (ParkingLot parkingLot : parkingLots) {
                ticket = parkingLot.packCar(car);
                ticketList.add(ticket);
            }
        }
        return ticketList;
    }

    public List<Car> fatchCar(List<Ticket> ticketList) {
        ArrayList<Car> carList = new ArrayList<>();
        Car car = null;
        for (Ticket ticket : ticketList) {
            for (ParkingLot parkingLot : parkingLots) {
                car = parkingLot.fatchCar(ticket);
                carList.add(car);
            }
        }
        return carList;
    }
}
