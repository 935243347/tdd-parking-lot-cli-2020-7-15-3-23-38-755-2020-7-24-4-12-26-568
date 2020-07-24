package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    public Ticket parkCar(Car car) {
        return new Ticket();
    }

    public Car fatchCar(Ticket ticket) {
        return new Car();
    }
    public List<Ticket> parkCar(List<Car> carList) {
        ArrayList<Ticket> ticketList = new ArrayList<>();
        for(Car car : carList){
            ticketList.add(new Ticket());
        }
        return ticketList;
    }
}
