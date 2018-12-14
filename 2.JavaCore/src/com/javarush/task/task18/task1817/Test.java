package com.javarush.task.task18.task1817;

public class Test {
    public static void main(String[] args) {

        double a = (double) (25.0/30.0) * (double) (100.0);

        double b = (double)Math.round(a*100)/100;

        System.out.println(b);
    }
}
