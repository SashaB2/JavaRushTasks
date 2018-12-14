package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static{
        labels.put(4.2,"d");
        labels.put(4.1,"dcc");
        labels.put(4.3,"d c");
        labels.put(4.4,"dv");
        labels.put(4.5,"r");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
