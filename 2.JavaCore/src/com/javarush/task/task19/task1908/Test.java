package com.javarush.task.task19.task1908;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        String s = "12 text var2 14 8ю 1";


        Pattern pattern = Pattern.compile("^\\d+ | \\d+ |^\\d+$| \\d+$");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()){
            System.out.println(matcher.group());
        }


    }
}
