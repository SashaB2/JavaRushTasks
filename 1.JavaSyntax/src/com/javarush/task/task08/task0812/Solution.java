package com.javarush.task.task08.task0812;

import org.omg.PortableInterceptor.NON_EXISTENT;

import java.io.*;
import java.util.ArrayList;

/*
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int intTemp = 0;
        int count1 = 0;
        int count2 = 0;


        for (int i = 0; i < 10; i++) {
            arr.add(Integer.parseInt(reader.readLine()));
        }

        intTemp = arr.get(0);

        for (int i = 0; i < arr.size(); i++) {


            if(intTemp == arr.get(i)){
                ++count1;
            }else if(intTemp != arr.get(i)){
                intTemp = arr.get(i);
                count1 = 1;
            }

            if(count1 > count2){
                count2 = count1;
            }

        }

        System.out.println(count2);

    }
}