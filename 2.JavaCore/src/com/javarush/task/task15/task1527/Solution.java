package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = "";
//        String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        String [] spilitUrl;
        String [] splitParam;
        Map<String, String> keyVal = new HashMap<>();
        Integer indexEquals = null;



        try{
            url = reader.readLine();
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        if(url.matches("https?:\\/\\/\\S+")){

            spilitUrl = url.split("\\?");

        }else {
            return;
        }

        splitParam = spilitUrl[1].split("&");


        String key1 = "";
        String value2 = "";
        String temp = "";

        String s = "";
        for (int i = 0; i < splitParam.length; i++) {

            s = splitParam[i];

            indexEquals = s.indexOf("=");

            if(indexEquals != -1) {
                keyVal.put(s.substring(0, indexEquals), s.substring(indexEquals + 1, s.length()));
                key1 = s.substring(0, indexEquals);
                value2 = s.substring(indexEquals + 1, s.length());
            }else {
                keyVal.put(s, "");
                key1 = s;
            }

            if(i < splitParam.length-1){
                System.out.print(key1 + " ");
            }
            else {
                System.out.print(key1);
            }

            if (key1.equals("obj")) {
                temp = value2;
            }
        }

        System.out.println();

        if(!temp.equals("")) {
            if (temp.matches("\\d+.\\d+")) {
                alert(Double.parseDouble(temp));
            } else {
                alert(temp);
            }
        }


//        keyVal.forEach((key, value) -> System.out.print(key + " "));
//
//        System.out.println();
//
//        Iterator<Map.Entry<String, String>> iterator = keyVal.entrySet().iterator();
//
//        while (iterator.hasNext()){
//
//            Map.Entry<String, String> pair = iterator.next();
//
//            if(pair.getKey().equals("obj")){
//
//                if(pair.getValue().matches("\\d+.\\d+")){
//                    alert(Double.parseDouble(pair.getValue()));
//                }else{
//                    alert(pair.getValue());
//                }
//            }
//
//        }







    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
