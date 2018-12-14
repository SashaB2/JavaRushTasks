package com.javarush.task.task17.task1721;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static void main(String[] args) {
        allLines.add("1");
        allLines.add("2");
        allLines.add("3");
        forRemoveLines.add("1");
        forRemoveLines.add("1");
    }
}
