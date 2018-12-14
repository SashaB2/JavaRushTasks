package com.javarush.task.task13.task1328;

public class Robot extends AbstractRobot {
    private String name;
    private static int hitCount;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }



}
