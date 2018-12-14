package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.Scanner;

public class Solution {

    static final String word = "world";

    public static void main(String[] args) {
        String fileName = null;
        try(BufferedReader readable =  new BufferedReader(new InputStreamReader(System.in))){
            fileName = readable.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count = 0;


        try(FileReader fileReader = new FileReader(fileName)) {
            int temp;
            String tempWord = "";

            while (fileReader.ready()){
                temp = fileReader.read();
                String temp1 = Character.toString((char)temp);
                if(temp1.equals(" ")){
                    tempWord += temp1;
                }
                else if(tempWord.equals(" ") && temp1.equals("w")){
                    tempWord += temp1;
                }else if(tempWord.equals(" w") && temp1.equals("o")){
                    tempWord += temp1;
                }else if(tempWord.equals(" wo") && temp1.equals("r")){
                    tempWord += temp1;
                }else if(tempWord.equals(" wor") && temp1.equals("l")){
                    tempWord += temp1;
                }else if(tempWord.equals(" worl") && temp1.equals("d")){
                    tempWord = "";
                    ++count;
                }else{
                    tempWord = "";
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(count);


    }
}
