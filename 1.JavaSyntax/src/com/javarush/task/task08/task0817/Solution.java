package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();



        map.put("dsdsv1", "dsdsv");
        map.put("dsdsmv2", "dsdsvd");
        map.put("dsdsvas3", "dsdsv");
        map.put("dsdsvass4", "dvsdsvas");
        map.put("dsdsvassn5", "dsdsv");
        map.put("dsdsvassnt6", "dvnsdsvast");
        map.put("dsdsvassntb7", "dvnsdsvastb");
        map.put("dsdsvassntbk8", "dsdsv");
        map.put("dsdsvassnutbk9", "dvnsdsvkuastb");
        map.put("dsdsvassnuntbk10", "dsdsvd");

        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> arr = new ArrayList<>();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();

        while(iterator.hasNext()) {
            int trigger = 0;

            Map.Entry<String, String> pair = iterator.next();

            while(iterator1.hasNext()){


                Map.Entry<String, String> pair1 = iterator1.next();

                if(pair.getValue().equals(pair1.getValue()) && trigger == 0){
                    trigger = 1;
                    continue;
                }else if(pair.getValue().equals(pair1.getValue()) && trigger == 1){

                    if(arr.contains(pair1.getValue())){
                        break;
                    }else {
                        arr.add(pair1.getValue());
                        break;
                    }
                }

            }
            iterator1 = map.entrySet().iterator();

        }

        for (int i = 0; i < arr.size(); i++) {
            removeItemFromMapByValue(map, arr.get(i));
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        removeTheFirstNameDuplicates(createMap());
    }
}
