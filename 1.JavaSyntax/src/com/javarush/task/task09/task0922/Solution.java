package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Date date = new Date( new Scanner(System.in).next());
//        System.out.println( new Scanner(System.in).next().toLowerCase());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy");
//
        System.out.println(simpleDateFormat.format(date).toUpperCase());
    }
}
