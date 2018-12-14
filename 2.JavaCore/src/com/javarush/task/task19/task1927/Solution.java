package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
//        InputStream inputStream = new FileInputStream("s");
//        BufferedInputStream br = new BufferedInputStream(System.in);
//        int a = br.read();
//        System.out.println(a);

        PrintStream pr0 = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream pr1 = new PrintStream(byteArrayOutputStream);
        System.setOut(pr1);
        testString.printSomething();
                String [] r = byteArrayOutputStream.toString().split("\\n");

        System.setOut(pr0);

        int count = 0;
        for(int i = 0; i <r.length ; i++) {
            if(count == 2){
                System.out.println("JavaRush - курсы Java онлайн");
                System.out.println(r[i]);
                count = 0;
            }else {
                System.out.println(r[i]);
            }
            ++count;

        }





    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
