package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream firstStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream secondStream = new PrintStream(byteArrayOutputStream);
        System.setOut(secondStream);
        testString.printSomething();


//        String result = byteArrayOutputStream.toString().replaceAll("\\D", "");

        char [] result = byteArrayOutputStream.toString().toCharArray();
        for(int i = 0; i < result.length ; i++) {
            if(Character.isDigit(result[i])){
                System.out.print(result[i]);
            }
        }


        System.setOut(firstStream);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
