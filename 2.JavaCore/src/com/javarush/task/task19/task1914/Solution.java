package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream first = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream second = new PrintStream(byteArrayOutputStream);
        System.setOut(second);
        testString.printSomething();
        String [] result = byteArrayOutputStream.toString().split(" ");
        String outs;

            if(result[1].equals("+")){
                outs = result[0] + " " + result[1] + " " + result[2] + " = " + (Integer.parseInt(result[0]) + Integer.parseInt(result[2]));
            }else if(result[1].equals("-")){
                outs = result[0] + " " + result[1] + " " + result[2] + " = " + (Integer.parseInt(result[0]) - Integer.parseInt(result[2]));
            }else{
                outs = result[0] + " " + result[1] + " " + result[2] + " = " + (Integer.parseInt(result[0]) * Integer.parseInt(result[2]));

            }

            System.setOut(first);
        System.out.println(outs);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

