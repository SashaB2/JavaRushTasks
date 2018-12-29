package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null || string.isEmpty())
            throw new TooShortStringException();


        int count = 0;
        for(int i = 0; i < string.length() ; i++) {
            if('\t' == string.charAt(i))
                ++count;
            if(count == 2)
                break;
        }
        if(count < 2)
            throw new TooShortStringException();

        int firstT = string.indexOf("\t");
        int seconfT = string.indexOf("\t", firstT+1);

        return string.substring(firstT + 1, seconfT);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
