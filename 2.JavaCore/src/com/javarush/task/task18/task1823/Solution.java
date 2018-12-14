package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String fileName;


        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){

            while (true){
                fileName = bufferedReader.readLine();
                if(fileName.equals("exit"))
                    return;

                new ReadThread(fileName).start();
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

            List<Integer> list = new ArrayList<>();
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int maxVal = Integer.MIN_VALUE;


            try(FileInputStream fileInputStream = new FileInputStream(this.fileName)) {

                while(fileInputStream.available()>0){
                    int counByte = fileInputStream.read();
                    list.add(counByte);
                }


                for(int i = 0; i < list.size(); i++) {
                    int temp = list.get(i);
                    for(int j = 0; j < list.size(); j++) {
                        if(temp == list.get(j)){
                            ++count;
                        }
                    }

                    map.put(temp, count);
                    count = 0;
                }

                for(Map.Entry<Integer, Integer> ma: map.entrySet()
                    ) {

                    if(maxVal < ma.getValue()){
                        maxVal = ma.getValue();
                    }

                }

                for(Map.Entry<Integer, Integer> ma: map.entrySet()
                        ) {

                    if(maxVal == ma.getValue()){
                        resultMap.put(this.fileName, ma.getKey());
                        break;
                    }

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
