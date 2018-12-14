package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считывай строки с клавиатуры и добавляй их в список, пока пользователь не введет строку "end".
3. Саму строку "end" не нужно добавлять в список.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        final String stopWord = "end";
        String str;
        int temp = 1;
        for(int i = 0; i < temp; i++){
            str = reader.readLine();
            if(str.equals("end")){
                break;
            }else{
                list.add(str);
                ++temp;
            }

        }

        for (String s: list
                ) {
            System.out.println(s);
        }
    }
}