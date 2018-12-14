package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine() + " ";
//
        //напишите тут ваш код
        char [] charArr = new char[s.length()];
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            charArr[i] = s.charAt(i);
        }


        ArrayList<Integer> arrInt = new ArrayList<>();
        ArrayList<Integer> firstLetterOfAllWordsv = new ArrayList<>();


        for (int i = 0; i < charArr.length; i++) {
            if(Character.toString(charArr[i]).matches("[а-яa-zA-ZА-Я]")){
                arrInt.add(i);
                continue;
            }

            if(arrInt.size()>0){
                firstLetterOfAllWordsv.add(arrInt.get(0));
                arrInt.clear();
            }

        }


        for (int a: firstLetterOfAllWordsv
             ) {
            charArr[a] = Character.toUpperCase(charArr[a]);
        }


        for (int i = 0; i < charArr.length -1; i++) {

            b.append(Character.toString( charArr[i]));

        }

        System.out.println(b.toString());



    }
}
