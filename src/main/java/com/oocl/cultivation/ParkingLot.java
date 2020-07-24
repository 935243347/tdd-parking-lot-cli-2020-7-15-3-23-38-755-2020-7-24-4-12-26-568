package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Ticket> ParkingList = new ArrayList<>();

    public Ticket packCar(Car car) {
        Ticket ticket = null;
        if(ParkingList.size() >= 10){
            System.out.println("parking lot capacity is full");
        } else {
            ticket = new Ticket(car);
            ParkingList.add(ticket);
        }
        return ticket;
    }

    public Car fatchCar(Ticket ticket) {
        for(Ticket actualTicket: ParkingList){
            if(actualTicket.equals(ticket)){
                ParkingList.remove(actualTicket);
                return actualTicket.getCar();
            }
        }
        System.out.println("no car");
        return null;
    }

}
