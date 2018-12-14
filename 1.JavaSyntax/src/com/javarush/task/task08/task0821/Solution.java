package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код

        Map<String, String> map = new HashMap<>();

        map.put("Lesyk1", "KyivStar1");
        map.put("Lesyk1", "KyivStar1");
        map.put("Lesyk1", "KyivStar1");
        map.put("Lesyk1", "KyivStar1");
        map.put("Lesyk1", "KyivStar1");
        map.put("Lesyk1", "KyivStar1");
        map.put("Lesyk1", "KyivStar1");
        map.put("Lesyk1", "KyivStar1");
        map.put("Lesyk1", "KyivStar1");
        map.put("Lesyk1", "KyivStar1");


        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
