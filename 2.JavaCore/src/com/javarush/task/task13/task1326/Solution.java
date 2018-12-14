package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> array = new ArrayList<>();
//        InputStream inputStream = new FileInputStream("C:\\Users\\B2\\Desktop\\test\\test.txt");
//        InputStream inputStream = new FileInputStream(reader.readLine());
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\B2\\Desktop\\test\\test.txt")));

        while(reader1.ready()){

            int a = Integer.parseInt(reader1.readLine());


        }




//        Collections.sort(array);
//
//        for (int i = 0; i < array.size(); i++) {
//            System.out.println(array.get(i));
//        }

        reader1.close();

    }
}
