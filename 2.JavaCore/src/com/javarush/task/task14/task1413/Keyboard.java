package com.javarush.task.task14.task1413;

public class Keyboard implements CompItem{

    @Override
    public String getName() {
        return  getClass().getName().split("\\.")[(getClass().getName().split("\\.")).length - 1];

    }

}
