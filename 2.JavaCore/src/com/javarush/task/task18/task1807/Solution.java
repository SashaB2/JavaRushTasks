package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\B2\\Desktop\\first.txt");
        FileInputStream fileInputStream = new FileInputStream(fileName);

        int count = 0;
        int asciiCode = 44;
        while (fileInputStream.available() > 0){
            int a = fileInputStream.read();
            if(a == asciiCode){
                ++count;
            }
        }
        System.out.println(count);

        fileInputStream.close();
    }
}
