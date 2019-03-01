package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            wheels = new ArrayList<Wheel>();
            String [] value2 = loadWheelNamesFromDB();

            if(loadWheelNamesFromDB().length != 4){
                throw new IllegalArgumentException();
            }else {
                for (int i = 0; i <value2.length ; i++) {
                    wheels.add(Wheel.valueOf(value2[i]));
                }
            }

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
//        Car car = new Car();
    }
}
