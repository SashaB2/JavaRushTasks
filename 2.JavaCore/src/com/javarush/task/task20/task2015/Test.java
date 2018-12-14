package com.javarush.task.task20.task2015;

import java.util.Base64;

public class Test {
    public static void main(String[] args) {
        String s = Base64.getEncoder().encodeToString("Hello".getBytes());
        System.out.println(s);
        byte [] a = Base64.getDecoder().decode(s);
        System.out.println(new String(a));

    }
}
