package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(isDateOdd("JANUARY 2 2020"));

    }



    public static boolean isDateOdd(String date) {

        Date d = new Date(date);
        Date dateZ = new Date(date);
        dateZ.setDate(1);
        dateZ.setMonth(0);

        long dateDifferent = d.getTime() - dateZ.getTime();

        long days = (dateDifferent/(1000*60*60*24))+1;

        if(days % 2 == 0){
            return false;

        }else {
            return true;

        }



    }


}
