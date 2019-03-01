package com.javarush.task.task26.task2601;

import java.lang.reflect.Array;
import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        //TDD
        System.out.println(Arrays.asList(sort(new Integer[]{13, 8, 15, 5, 17})));
        System.out.println("----------------------------------------------");
        System.out.println(Arrays.asList(sort(new Integer[]{13, 8, 15, 5, 17, 11})));
        System.out.println("----------------------------------------------");
        System.out.println(Arrays.asList(sort(new Integer[]{1,2,3,3,3,4,5})));
        System.out.println("----------------------------------------------");
        System.out.println(Arrays.asList(sort(new Integer[]{1,2,4,4,4,5})));
        System.out.println("----------------------------------------------");
        System.out.println(Arrays.asList(sort(new Integer[]{})));
        System.out.println("----------------------------------------------");
        System.out.println(Arrays.asList(sort(new Integer[]{0})));
    }

    public static Integer[] sort(Integer[] array) {
        if(array.length == 0 || array.length == 1) return array;
        int mediana;
        Arrays.sort(array);

        if (array.length % 2 != 0) {
            mediana = array[array.length / 2];
        } else {
            mediana = (array[array.length / 2] + array[(array.length - 1) / 2]) / 2;
        }

        List<Integer> list = Arrays.asList(array);

        Comparator<Integer> compareByMediana = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(mediana - o1) - Math.abs(mediana - o2);
            }
        };

        Collections.sort(list, compareByMediana);

        return list.toArray(array);
    }
}
