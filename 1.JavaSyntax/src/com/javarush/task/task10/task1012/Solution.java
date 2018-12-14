package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();


        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код
        HashMap<String, Integer> alph = new HashMap<>();

        for (int i = 0; i <abcArray.length ; i++) {
            alph.put(Character.toString(abcArray[i]), 0);
        }

        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < list.get(i).length(); j++) {

                for (int k = 0; k < alphabet.size(); k++) {
                    if(list.get(i).charAt(j) == alphabet.get(k)){

                        for (Map.Entry<String, Integer> pair: alph.entrySet()
                                ) {

                            if(pair.getKey().equals(Character.toString(list.get(i).charAt(j)))){
                                alph.put(pair.getKey(), pair.getValue() + 1);
                            }
                        }

                    }
                }

            }

        }


        for (int i = 0; i < abcArray.length; i++) {

            for (Map.Entry<String, Integer> pair: alph.entrySet()
                    ) {
                if(Character.toString(abcArray[i]).equals(pair.getKey())){
                    System.out.println(abcArray[i] + " " + pair.getValue());
                }


            }
        }



    }


}
