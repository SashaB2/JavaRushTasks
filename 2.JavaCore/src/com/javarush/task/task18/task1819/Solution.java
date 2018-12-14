package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        String [] fileName = new String[2];

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            for(int i = 0; i < fileName.length; i++) {
                fileName[i] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            ArrayList<Integer> listTemp = new ArrayList<>();

            FileInputStream fileInputStream = new FileInputStream(fileName[0]);
            while(fileInputStream.available() > 0){
                int temp = fileInputStream.read();
                listTemp.add(temp);
            }

            fileInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream(fileName[0]);
            fileInputStream = new FileInputStream(fileName[1]);
            while(fileInputStream.available() > 0){
                int temp = fileInputStream.read();
                fileOutputStream.write(temp);
            }
            for(int temp : listTemp) {
                fileOutputStream.write(temp);
            }


                fileInputStream.close();
                fileOutputStream.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
