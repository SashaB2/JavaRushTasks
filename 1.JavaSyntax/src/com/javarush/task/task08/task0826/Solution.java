package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Пять победителей
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

//        for (int i = 0; i < array.length; i++) {
//            array[i] = (int)Math.floor(Math.random()*101);
//        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        int countOne = 0;
        int countSecond = 1;
        int temp;
        int one;
        int second;


        while (countSecond <= array.length-1){

             one = array[countOne];
             second = array[countSecond];

            if(one < second){
                temp = array[countOne];
                array[countOne] = array[countSecond];
                array[countSecond] = temp;
                countOne = -1;
                countSecond = 0;
            }


            ++countOne;
            ++countSecond;


        }

    }
}
