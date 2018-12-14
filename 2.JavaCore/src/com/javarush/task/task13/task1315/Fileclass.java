package com.javarush.task.task13.task1315;

import java.io.*;

public class Fileclass {

    public static void main(String[] args) throws IOException{
        InputStream inStream = new FileInputStream("C:\\test\\source.txt");
        OutputStream outputStream = new FileOutputStream("C:\\test\\result.txt");

        while(inStream.available() > 0){



            int data = inStream.read();


            outputStream.write(Character.getNumericValue(data));

        }

        inStream.close();
        outputStream.close();
    }
}
