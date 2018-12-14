package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        String [] fileName = new String[3];

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            for(int i = 0; i < fileName.length; i++) {
                fileName[i] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileOutputStream fileOutputStream;
            FileInputStream fileInputStream;

            for(int i = 1; i < fileName.length; i++) {
                fileOutputStream = new FileOutputStream(fileName[0]);
                fileInputStream = new FileInputStream(fileName[i]);

                while(fileInputStream.available() > 0){
                    int temp =fileInputStream.read();
                    fileOutputStream.write(temp);
                }

                fileInputStream.close();
                fileOutputStream.close();
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
