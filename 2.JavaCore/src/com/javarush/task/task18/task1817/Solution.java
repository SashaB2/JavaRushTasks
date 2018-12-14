package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {

    static double countSpaces;
    static double countSymbols;

    public static void main(String[] args) {

        int temp;
        double temp1;
        double temp2;

        try(FileInputStream fileInputStream = new FileInputStream(args[0])){
            while(fileInputStream.available() > 0){
                temp = fileInputStream.read();
                ++countSymbols;
                if(temp == 32)
                    ++countSpaces;

            }

            temp1 = (double) ((countSpaces/countSymbols)*100.0);

            temp2 = (double) Math.round(temp1*100)/100;

            System.out.println(temp2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
