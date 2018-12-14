package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream file = new FileInputStream(br.readLine());
            int a = Integer.MAX_VALUE;
            int b;
            while(file.available() > 0){
                b = file.read();
                if(a>b){
                    a = b;
                }
            }
            System.out.println(a);
            br.close();
            file.close();
        }catch (IOException e){}
    }
}
