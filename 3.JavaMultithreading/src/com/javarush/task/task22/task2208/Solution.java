package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
//        map.put(null, null);
//        map.put(null, null);
//        map.put(null, null);
//        map.put(null, null);

//        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();

//        params.entrySet().stream()
//                .filter(pair ->
//                        pair.getKey() != null
//                                &&  pair.getValue() != null
//                                && !pair.getKey().isEmpty()
//                                && !pair.getValue().isEmpty()
//                ).forEach(pair ->
//                stringBuilder.append(pair.getKey())
//                        .append(" = '")
//                        .append(pair.getValue())
//                        .append("' and ")
//        );

        params.forEach((k,v) -> {
            if(k != null &&
                    v != null &&
                    !k.isEmpty() &&
                    !v.isEmpty()){
                stringBuilder.append(k + " = " + "'" + v + "'");
                stringBuilder.append(" and ");
            }

        });

        int len = stringBuilder.length();
        stringBuilder.setLength(len > 4 ? len-5 : 0);
        return stringBuilder.toString();

//        return stringBuilder.toString().substring(0, stringBuilder.length() - 5);
    }
}
