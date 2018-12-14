package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\B2\\Desktop\\first.txt"));
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(args[0]));
            List<Integer> list = new ArrayList<>();
            SortedMap<Integer, Integer> result = new TreeMap<Integer, Integer>();
            int temp;
            int countSymbols = 0;

            while (bufferedInputStream.available() > 0){
                temp = bufferedInputStream.read();
                list.add(temp);
            }

            for(int i = 0; i < list.size(); i++) {

//                if(list.get(i) >= 32 && list.get(i) <= 127){
                    temp = list.get(i);
//                }else{
//                    continue;
//                }



                for(int j = 0; j < list.size(); j++) {
//                    if(temp == list.get(j) && temp >= 32 && temp <= 127){
                    if(temp == list.get(j)){
//                        list.remove(j);
                        ++countSymbols;
                    }
                }
                result.put(temp, countSymbols);
                countSymbols=0;
            }

            for(Map.Entry<Integer, Integer> a: result.entrySet()
                ) {

                int b = a.getKey();

                System.out.println((char)b + " " + a.getValue());
            }

            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
