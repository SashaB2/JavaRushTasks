package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\B2\\Desktop\\first.txt");
            FileInputStream fileInputStream = new FileInputStream(br.readLine());
//            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\B2\\Desktop\\second.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(br.readLine());
            List<Double> noFormatterNumbers = new ArrayList<>();
            List<Long> roundedNumbers = new ArrayList<>();
            List<char[]> numberArrList = new ArrayList<>();

            String decodedASCII="";
            while(fileInputStream.available() > 0){
                int byteCount = fileInputStream.read();

                if(byteCount != 32){
                    decodedASCII += (char) byteCount;
                }

                if(byteCount == 32 || fileInputStream.available() == 0){
                    if(decodedASCII.length()>0){
                        noFormatterNumbers.add(Double.parseDouble(decodedASCII));
                        decodedASCII = "";
                    }

                }

            }

            for(Double oddNumber:noFormatterNumbers
                ) {
                roundedNumbers.add(Math.round(oddNumber));
            }

            for(Long number:roundedNumbers
                ) {
                char [] arr = new char[String.valueOf(number).length()];
                String temp = String.valueOf(number);

                for(int i = 0; i < temp.length(); i++) {
                    arr[i] = temp.charAt(i);
                }
                numberArrList.add(arr);
            }

            for(char [] symbols:numberArrList
                ) {
                for(int i = 0; i < symbols.length; i++) {
                    fileOutputStream.write((int)symbols[i]);
                }

                fileOutputStream.write(32);
            }


            br.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
