package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Double d;
        Short s;
        int a;
        Integer i;

        for(;;){

            str = reader.readLine();

            if(str.equals("exit")){
                break;
            }else if(str.matches("-?\\d+\\.\\d+")){
                d = Double.parseDouble(str);
                print(d);
            }else if(str.matches("-?\\d+")){
                i = Integer.parseInt(str);
                if(i>0 && i<128) {
                    s = i.shortValue();
                    print(s);
                }
                else {
                    print(i);
                }
            }else{
                print(str);
            }

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
