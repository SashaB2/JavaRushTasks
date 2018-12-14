package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String fileNames[] = new String[2];

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            for(int i = 0; i < fileNames.length; i++) {
                fileNames[i] = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader(fileNames[0]);
            FileWriter fileWriter = new FileWriter(fileNames[1]);
            int temp;

            for(int i = 1; fileReader.ready(); i++) {
                temp = fileReader.read();
                if(i%2==0){
                    fileWriter.write(temp);
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