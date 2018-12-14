package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream file = new FileInputStream(br.readLine());
            int a = Integer.MIN_VALUE;
            int b;
            while(file.available() > 0){
                b = file.read();
                if(a<b){
                    a = b;
                }
            }
            System.out.println(a);
            br.close();
            file.close();
        }catch (IOException e){}

    }
}
