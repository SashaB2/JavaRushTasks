package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String filename = bufferedReader.readLine();
            bufferedReader.close();

            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

            while (bufferedReader.ready()){
                String a =  bufferedReader.readLine();
                if(a.startsWith(args[0] + " ")){
                    System.out.println(a);
                }
            }

bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
