package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static volatile boolean isIncorrect;

    public static void main(String[] args) {
        String fileName;


        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){

        while (true){
            fileName = bufferedReader.readLine();

            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
            if(isIncorrect){
                break;
            }
        }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run(){

            Thread c = Thread.currentThread();

            try(FileInputStream fileInputStream = new FileInputStream(this.fileName)) {

            } catch (FileNotFoundException e) {
                System.out.println(this.fileName);
                isIncorrect = true;
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}