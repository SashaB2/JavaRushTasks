package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream file = new FileInputStream(br.readLine());
//            FileInputStream file = new FileInputStream("C:\\Users\\B2\\Desktop\\first.txt");
            ArrayList<Integer> arrayList = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int b;
            while(file.available() > 0){
                b = file.read();
                arrayList.add(b);
            }

            int count = 0;
            for(int i = 0; i < arrayList.size(); i++) {
                for(int j = 0; j < arrayList.size(); j++){
                    if(arrayList.get(i) == arrayList.get(j)){
                        count +=1;
                    }
                }
                map.put(arrayList.get(i), count);
                count = 0;
            }
            int max = Integer.MIN_VALUE;
            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if(max < entry.getValue()){
                    max = entry.getValue();
                }
            }

            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if(max == entry.getValue()){
                    System.out.print(entry.getKey() + " ");
                }
            }




            br.close();
            file.close();
        }catch (IOException e){}
    }
}
