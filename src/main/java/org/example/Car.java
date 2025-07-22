package org.example;

public abstract class Car {
    private final String carType;
    private boolean isAvailable;


    public Car(String carType) {
        this.carType = carType;
        this.isAvailable=true;

    }


    public String getCarType() {
        return carType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
