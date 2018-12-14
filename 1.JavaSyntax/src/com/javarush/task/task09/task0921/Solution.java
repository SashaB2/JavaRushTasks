package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {

        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a;
        List<Integer> arr = new ArrayList<>();

        try {
            while(true){
                a = Integer.parseInt(reader.readLine());
                arr.add(a);
            }
        }
        catch (IOException e){

        }catch (NumberFormatException e){
            for (Integer b: arr
                    ) {
                System.out.println(b);
            }
        }
    }
}
