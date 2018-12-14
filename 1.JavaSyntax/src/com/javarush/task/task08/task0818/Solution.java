package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> counting = new HashMap<String, Integer>();

        counting.put("qq1", 100);
        counting.put("qq2", 200);
        counting.put("qq3", 300);
        counting.put("qq4", 400);
        counting.put("qq5", 500);
        counting.put("qq6", 600);
        counting.put("qq7", 700);
        counting.put("qq8", 800);
        counting.put("qq9", 900);
        counting.put("qq10", 1100);

        return counting;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> pair = iterator.next();

            if(pair.getValue() < 500){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}