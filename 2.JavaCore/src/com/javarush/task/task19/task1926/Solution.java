package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
//        String fileName = "C:\\Users\\B2\\Desktop\\1.txt";
        BufferedReader brf = new BufferedReader(new FileReader(fileName));

        StringBuilder temp = new StringBuilder();
        String line;
        while ((line = brf.readLine())!=null){
            for(int i = line.length()-1; i >=0 ; i--) {
                temp.append(line.charAt(i));
            }
            System.out.println(temp.toString());
            temp.delete(0, temp.length());
        }

        br.close();
        brf.close();
    }
}
