package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        FileInputStream inputStream = new FileInputStream("C:\\Users\\B2\\Desktop\\first.txt");
        // Создаем поток-записи-байт-в-файл
//        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\B2\\Desktop\\second.txt");


        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
            System.out.println(buffer.length);
            for(int i = 0; i < buffer.length; i++) {
                System.out.println(buffer[i]);
            }
        }


//        inputStream.reset();
//        outputStream.flush();
        inputStream.close();
        outputStream.close();
    }
}
