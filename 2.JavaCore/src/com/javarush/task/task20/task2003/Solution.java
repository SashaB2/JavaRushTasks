package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        String filePath = new Scanner(System.in).nextLine();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        load(fileInputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties pr = new Properties();
        properties.forEach((key, value) ->{pr.put(key, value);});
        pr.store(outputStream, "--properties--");
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties pr = new Properties();
        pr.load(inputStream);
        pr.forEach((key, value) -> {properties.put((String)key, (String)value);});
        inputStream.close();
    }

    public static void main(String[] args) {

    }
}
