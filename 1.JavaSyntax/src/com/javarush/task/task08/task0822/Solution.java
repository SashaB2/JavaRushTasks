package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // find minimum here — найти минимум тут
        int min = Integer.MAX_VALUE;

        Iterator<Integer> iterator = array.iterator();

        for (int a: array
                ) {
            if(min > a){
                min = a;
            }
        }




        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //create and initialize a list here - создать и заполнить список тут
        Scanner sc = new Scanner(System.in);
        List<Integer> list  = new ArrayList<>();
        int N = sc.nextInt();

        while (--N >= 0){
            list.add(sc.nextInt());

        }

        return list;
    }
}
