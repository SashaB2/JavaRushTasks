package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String name = "C:\\test\\source.txt";
        String name = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(name);




        while (inputStream.available() > 0){

            System.out.print((char)inputStream.read());
        }

        inputStream.close();
    }
}