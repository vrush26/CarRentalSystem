package org.example;

import java.time.LocalDateTime;

public class Reservation {
    private final String car;
    private final LocalDateTime reservationStartDate;
    private final LocalDateTime reservationEndDate;


    public Reservation(int days, LocalDateTime durationStartDate, String car) {
        this.car = car;
        this.reservationStartDate = durationStartDate;
        this.reservationEndDate = durationStartDate.plusDays(days);
    }

    //checks if current booking dates overlaps with the existing reservation date
    public boolean isOverLapWith(LocalDateTime currentBookingStartDate, LocalDateTime currentBookingEndDate) {
        return !(currentBookingStartDate.isBefore(reservationEndDate) && currentBookingEndDate.isAfter(reservationStartDate));
    }

    public String getCar() {
        return car;
    }
}
