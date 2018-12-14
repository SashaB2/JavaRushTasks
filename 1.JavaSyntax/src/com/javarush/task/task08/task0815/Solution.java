package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();



            map.put("dsdsv1", "dsdsv");
            map.put("dsdsmv2", "dsdsvd");
            map.put("dsdsvas3", "dsdsvas");
            map.put("dsdsvass4", "dvsdsvas");
            map.put("dsdsvassn5", "dvnsdsvas");
            map.put("dsdsvassnt6", "dvnsdsvast");
            map.put("dsdsvassntb7", "dvnsdsvastb");
            map.put("dsdsvassntbk8", "dvnsdsvkastb");
            map.put("dsdsvassnutbk9", "dvnsdsvkuastb");
            map.put("dsdsvassnuntbk10", "dvnsdnsvkuastb");



        return map;


    }


    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код


        int count = 0;
        for (Map.Entry<String, String> pair: map.entrySet()
                ) {
            if(pair.getValue().equals(name)){
                ++count;
            }

        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair: map.entrySet()
                ) {
            if(pair.getKey().equals(lastName)){
                ++count;
            }

        }
        return count;
    }

    public static void main(String[] args) {


    }
}
