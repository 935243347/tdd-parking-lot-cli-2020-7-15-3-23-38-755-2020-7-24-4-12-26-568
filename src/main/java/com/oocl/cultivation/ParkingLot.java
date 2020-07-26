package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Ticket> parkingList = new ArrayList<>();

    private int totalCapacity;

    public ParkingLot(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Ticket packCar(Car car) {
        Ticket ticket = null;
        if (this.parkingList.size() >= this.totalCapacity) {
            System.out.print("Not enough position.");
        } else {
            ticket = new Ticket(car);
            this.parkingList.add(ticket);
        }
        return ticket;
    }

    public Car fatchCar(Ticket ticket) {
        if (ticket != null) {
            for (Ticket actualTicket : this.parkingList) {
                if (actualTicket.equals(ticket)) {
                    this.parkingList.remove(actualTicket);
                    return actualTicket.getCar();
                }
            }
            System.out.print("Unrecognized parking ticket.");
            return null;
        }
        System.out.print("Please provide your parking ticket.");
        return null;
    }

    public List<Ticket> getParkingList() {
        return parkingList;
    }
}
