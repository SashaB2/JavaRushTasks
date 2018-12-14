package com.javarush.task.task14.task1409;

/* 
Мосты
*/

public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new WaterBridge());
        println(new WaterBridge());
        println(new SuspensionBridge());
        println(new SuspensionBridge());
        println(new SuspensionBridge());
    }

    //add println method here

    public static void println(Bridge o){

        System.out.println(o.getCarsCount());

    }

}

