package com.oocl.cultivation;


import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        ParkingLot minParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : this.parkingLots) {
            if(parkingLot.getParkingList().size() < minParkingLot.getParkingList().size()){
                minParkingLot = parkingLot;
            }
        }
        return minParkingLot.packCar(car);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
