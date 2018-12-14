package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = "C:\\Users\\B2\\Desktop\\1.txt";
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        ArrayList<String> filedataContainer = readFileData(fileName);


        for(String lineFromFile: filedataContainer
            ) {
            String [] tempString = lineFromFile.split(" ");
            for(int i = 0; i < tempString.length; i++) {
                String te = tempString[i];
                for(Map.Entry<Integer, String> pair: map.entrySet()){
                    if(String.valueOf(pair.getKey()).equals(te)){
                        tempString[i] = pair.getValue();
                    }
                }

            }
            String temp = "";
            for(int j = 0; j < tempString.length; j++) {
                if(j==tempString.length-1){
                    temp += tempString[j];
                }else{
                    temp += tempString[j] + " ";
                }
            }

            System.out.println(temp);
            temp = null;
        }

//            filedataContainer.forEach((value) ->{                   //run by lines of file
//            String [] tempString = value.split(" ");
//            for(int i = 0; i < tempString.length; i++) {        //runs by words of file
//
//
//                int finalI = i;
//                map.forEach((key, val) -> {
//                    if(String.valueOf(tempString[finalI]).equals(key)){         //compare values
//                        System.out.println(tempString[finalI]);
//                    }
//                });
//            }
//
//            String temp = "";
//            for(int i = 0; i < tempString.length; i++) {
//                if(i==tempString.length-1){
//                    temp += tempString[i];
//                }else{
//                    temp += tempString[i] + " ";
//                }
//            }
//
//            System.out.println(temp);
//            temp = null;
//        });




    }

    static  ArrayList<String> readFileData(String fileName) throws IOException {
        ArrayList<String> filedataContainer = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()){
            filedataContainer.add(bufferedReader.readLine());
        }
        bufferedReader.close();
        return filedataContainer;

    }
}
