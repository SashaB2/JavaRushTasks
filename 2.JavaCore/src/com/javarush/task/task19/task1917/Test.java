package com.javarush.task.task19.task1917;

import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String str = "0123456789";
        FileConsoleWriter fileWriter = new FileConsoleWriter("C:\\Users\\B2\\Desktop\\first.txt");

        byte[]bytes = str.getBytes();

        for(int a: bytes
            ) {
            fileWriter.write(a);
        }

    }
}
