package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        String[] fileName = new String[2];
        try {
            BufferedReader readable = new BufferedReader(new InputStreamReader(System.in));
            for(int i = 0; i < fileName.length; i++) {
                fileName[i] = readable.readLine();
            }
            readable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        fileName[0] = "C:\\Users\\B2\\Desktop\\first.txt";
//        fileName[1] = "C:\\Users\\B2\\Desktop\\second.txt";

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName[0]));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName[1]));


            String temp = "";

            while(fileReader.ready()){
                temp += (char)fileReader.read();
            }

            String [] arr = temp.split(" ");

            for(int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);

                if(arr[i].matches("\\d+")){
                    fileWriter.write(arr[i] + " ");
                }
            }

        fileReader.close();
        fileWriter.close();
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
