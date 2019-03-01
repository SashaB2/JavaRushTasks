package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    final int MAX_TRUCK_SPEED = 80;
    final int MAX_SEDAN_SPEED = 120;
    final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        return isSummer(date, SummerStart, SummerEnd)?
                getSummerConsumption(length):
                getWinterConsumption(length);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred())
            return numberOfPassengers;
        else
            return 0;

    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        return date.after(summerStart) && date.before(summerEnd);
    }

//    public static void main(String[] args) {
//        Date d = new Date(2019, 5, 15);
//        Date d1 = new Date(2019, 6, 1);
//        Date d2 = new Date(2019, 8, 1);
//        System.out.println(isSummer(d,d1,d2));
//    }

    public double getWinterConsumption(int length){
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();

        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    private boolean canPassengersBeTransferred(){
        return isDriverAvailable() && fuel > 0;
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();


    public static Car create(int type, int numberOfPassengers){
        switch (type){
            case 0:
                return new Truck(numberOfPassengers);
            case 1:
                return new Sedan(numberOfPassengers);
            case 2:
                return new Cabriolet(numberOfPassengers);
        }
        return null;
    }
}