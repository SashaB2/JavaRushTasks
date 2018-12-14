package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) {
        int count = 0;
        int temp;
        try(FileInputStream fileInputStream = new FileInputStream(args[0])){
            while (fileInputStream.available() > 0){
                 temp = fileInputStream.read();
                if((temp >= 65 && temp <= 90) ||  (temp >= 97 && temp <= 122))
                    ++count;
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
