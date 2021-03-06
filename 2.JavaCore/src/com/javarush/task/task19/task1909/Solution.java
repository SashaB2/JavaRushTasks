package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

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

            for(int i = 0; i < temp.length(); i++) {
                String temp1 = Character.toString(temp.charAt(i));
                if(temp1.equals(".")){
                    temp1 = "!";
                }
                fileWriter.write(temp1);
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
