package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream1S = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream1S);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(result.getBytes());
        fileOutputStream.close();

        System.setOut(printStream);
        System.out.println(result);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

