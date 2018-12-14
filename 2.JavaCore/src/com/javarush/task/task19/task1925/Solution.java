package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = "C:\\Users\\B2\\Desktop\\1.txt";
//        String file1 = args[0];
//        String file2 = args[1];
        String file2 = "C:\\Users\\B2\\Desktop\\2.txt";
        BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList1 = new ArrayList<>();

        while (br.ready()){
            String a = br.readLine();
//            System.out.println(a);
            if(a == null) continue;
            arrayList.add(a);
        }

        for(int i = 0; i < arrayList.size(); i++) {

            String[] fileLine = arrayList.get(i).split(" ");
            for(int j = 0; j < fileLine.length; j++) {
                if(fileLine[j].length() > 6){
                    arrayList1.add(fileLine[j]);
                }
            }
        }


        for(int i = 0; i < arrayList1.size(); i++) {
            if(i == arrayList1.size()-1){
                bw.write(arrayList1.get(i));
            }else{
                bw.write(arrayList1.get(i) + ",");
            }
        }


        bw.close();
        br.close();
    }
}
