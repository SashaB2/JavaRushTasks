package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        String str = new Scanner(System.in).nextLine();
        String vowels = "";
        String consonant = "";
        char temp;
        char [] containsString = new char[str.length()];


        for (int i = 0; i < str.length(); i++) {

//            containsString[i] = str.charAt(i);
            if(isVowel(str.charAt(i))){
                vowels += Character.toString(str.charAt(i)) + " ";
            }else if(Character.isWhitespace(str.charAt(i))){
                continue;
            }
            else if(!(isVowel(str.charAt(i)))){
                consonant += Character.toString(str.charAt(i)) + " ";
            }
        }

        System.out.println(vowels);
        System.out.println(consonant);

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}