package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)throws FileNotFoundException, IOException {
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\B2\\Desktop\\first.txt");
//        FileOutputStream fileOutputStream0 = new FileOutputStream("C:\\Users\\B2\\Desktop\\second.txt");
//        FileOutputStream fileOutputStream1 = new FileOutputStream("C:\\Users\\B2\\Desktop\\third.txt");
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream fileOutputStream0 = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());



        int count;
        int capacity1;
        int capaccity2;

        if(fileInputStream.available() > 0){
            capacity1 = (int) Math.ceil((float)fileInputStream.available()/2.0);
            capaccity2 = fileInputStream.available() - capacity1;

            byte arr1 [] = new byte[capacity1];
            byte arr2 [] = new byte[capaccity2];
            count = fileInputStream.read(arr1);
            fileOutputStream0.write(arr1);
            count = fileInputStream.read(arr2);
            fileOutputStream1.write(arr2);

        }


        fileInputStream.close();
        fileOutputStream0.close();
        fileOutputStream1.close();
    }
}
