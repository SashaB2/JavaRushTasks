package com.javarush.task.task14.task1409;

public class WaterBridge implements Bridge{

    final static int a = (int)Math.floor(Math.random()*101);

    public int getCarsCount(){

        return a;

    }
}
