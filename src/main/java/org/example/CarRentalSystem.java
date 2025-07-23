package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarRentalSystem {

    private final List<Car> cars = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();
    LocalDateTime CurrentBookingEndDate;

    public void addCar(Car car) {
        cars.add(car);
    }

    public Reservation reserveCar(int days, String carType, LocalDateTime reservationStartDate) throws Exception {
        CurrentBookingEndDate = reservationStartDate.plusDays(days);
        List<Car> matchedCars = getCarsByType(carType);

        for (Car car : matchedCars) {
            boolean isAvailableNow = car.isAvailable();//checked if car is avaialble in list
            boolean notOverlapping = isCarAvailable(reservationStartDate, car, days);

            if (isAvailableNow || notOverlapping) {
                Reservation reservation = new Reservation(days, reservationStartDate, carType);
                reservations.add(reservation);
                car.setAvailable(false); // assume car is now booked
                return reservation;
            }
        }
        throw new Exception("No available " + carType + " cars for the requested period.");


    }

    // Check if the car is available by ensuring none of its existing reservations overlap with the requested period
    private boolean isCarAvailable(LocalDateTime startDate, Car car, int days) {
        CurrentBookingEndDate = startDate.plusDays(days);
        for (Reservation Reservation : reservations) {
            if ((Reservation.getCar().equals(car.getCarType()) && Reservation.isOverLapWith(startDate, CurrentBookingEndDate))) {
                return true;
            }
        }
        return false;

    }

    private List<Car> getCarsByType(String carType) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCarType().equalsIgnoreCase(carType)) {
                result.add(car);
            }
        }
        return result;
    }

}


