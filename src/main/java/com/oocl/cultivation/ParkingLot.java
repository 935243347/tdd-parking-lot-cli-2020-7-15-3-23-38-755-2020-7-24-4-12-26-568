package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Ticket> parkingList = new ArrayList<>();

    private int totalCapacity;

    private int availablePosition;

    public ParkingLot(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public synchronized Ticket packCar(Car car) {
        Ticket ticket = null;
        if (this.parkingList.size() >= this.totalCapacity) {
            System.out.print("Not enough position.");
        } else {
            ticket = new Ticket(car);
            this.parkingList.add(ticket);
            availablePosition++;
        }
        return ticket;
    }

    public synchronized Car fatchCar(Ticket ticket) {
        if (ticket != null) {
            for (Ticket actualTicket : this.parkingList) {
                if (actualTicket.equals(ticket)) {
                    this.parkingList.remove(actualTicket);
                    availablePosition--;
                    return actualTicket.getCar();
                }
            }
            System.out.print("Unrecognized parking ticket.");
            return null;
        }
        System.out.print("Please provide your parking ticket.");
        return null;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getAvailablePosition() {
        return availablePosition;
    }
}
