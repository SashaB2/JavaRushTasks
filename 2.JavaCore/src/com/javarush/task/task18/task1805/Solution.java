package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream file = new FileInputStream(br.readLine());
//            FileInputStream file = new FileInputStream("C:\\Users\\B2\\Desktop\\first.txt");
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<Integer> arrayList1 = new ArrayList<>();
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
            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                arrayList1.add(entry.getKey());
            }

            int first;
            int second;
            int temp;
            for(int i = 1; i < arrayList1.size(); i++) {
                first = arrayList1.get(i-1);
                second = arrayList1.get(i);

                if(first > second){
                    temp = second;
                    arrayList1.set(i, first);
                    arrayList1.set(i-1, temp);
                    i=0;
                }
            }

            for(int a:arrayList1
                ) {
                System.out.print(a + " ");
            }


            br.close();
            file.close();
        }catch (IOException e){}
    }
}
