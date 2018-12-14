package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\B2\\Desktop\\first.txt");
//        FileOutputStream fileOutputStream0 = new FileOutputStream("C:\\Users\\B2\\Desktop\\second.txt");
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream fileOutputStream0 = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        int count;
        while(fileInputStream.available() > 0){
            count = fileInputStream.read();
            arr.add(count);
        }


        Collections.reverse(arr);

        for(int i = 0; i < arr.size(); i++) {
            count = arr.get(i);
            fileOutputStream0.write(count);

        }

        fileInputStream.close();
        fileOutputStream0.close();
    }
}
