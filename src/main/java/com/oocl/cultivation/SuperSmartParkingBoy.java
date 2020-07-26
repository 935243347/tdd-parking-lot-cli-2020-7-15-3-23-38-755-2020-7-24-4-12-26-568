package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    private List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        ParkingLot minParkingLot = parkingLots.get(0);
        double minAvailablePositionRate = (double)minParkingLot.getAvailablePosition()/minParkingLot.getTotalCapacity();
        for (ParkingLot parkingLot : this.parkingLots) {
            double availablePositionRate = (double)parkingLot.getAvailablePosition()/parkingLot.getTotalCapacity();
            if(availablePositionRate < minAvailablePositionRate){
                minParkingLot = parkingLot;
            }
        }
        return minParkingLot.packCar(car);
    }

    public Car fatchCar(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.fatchCar(ticket);
        }
        return null;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}