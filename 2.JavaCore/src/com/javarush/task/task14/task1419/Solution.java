package com.javarush.task.task14.task1419;

import java.nio.channels.ClosedByInterruptException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.jar.JarException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
            exceptions.add(new NumberFormatException());
            exceptions.add(new InstantiationException());
            exceptions.add(new RuntimeException());
            exceptions.add(new NullPointerException());
            exceptions.add(new InterruptedException());
            exceptions.add(new ClassNotFoundException());
            exceptions.add(new NoSuchMethodException());
            exceptions.add(new JarException());
            exceptions.add(new ClosedByInterruptException());

        }

        //напишите тут ваш код

    }
}
