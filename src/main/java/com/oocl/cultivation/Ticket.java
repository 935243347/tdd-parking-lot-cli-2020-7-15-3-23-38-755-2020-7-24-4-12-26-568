package com.oocl.cultivation;

import java.util.Objects;

public class Ticket {
    private Car car;

    public Ticket(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return car.equals(ticket.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car);
    }
}
