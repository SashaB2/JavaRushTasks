package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
//        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java. dfbdfzb fdzgbfzd"));
    }

    public static String getPartOfString(String string) {
        if(string == null || string.isEmpty()){
            throw new TooShortStringException();
        }
        char space = ' ';
        int count = 0;

            for(int i = 0; i < string.length(); i++) {
                if(space == string.charAt(i))
                    ++count;
                if(count == 4)
                    break;
            }
            if(count < 4){
                throw new TooShortStringException();
            }
            String [] spl = string.split(" ");
        return spl[1]+ " " +spl[2]+ " " +spl[3]+ " " +spl[4];
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
