package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];

        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());

        }



        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код

        int a;
        int b;
        int tempFirdt = 0;
        int tempsecond = 1;
        int temp;
        boolean trigger = true;

        while(trigger){


            a = array[tempFirdt];
            b = array[tempsecond];

            if(a<b){
                temp = array[tempFirdt];
                array[tempFirdt] = array[tempsecond];
                array[tempsecond] = temp;
                tempFirdt = 0;
                tempsecond = 1;

            }else {
                ++tempFirdt;
                ++tempsecond;
            }
            if(tempsecond == array.length){
                trigger = false;
            }
        }
    }
}
