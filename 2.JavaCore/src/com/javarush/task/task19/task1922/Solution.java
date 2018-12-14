package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
//        words.add("A");
//        words.add("B");
//        words.add("V");
    }

    public static void main(String[] args) throws IOException {
        Solution $ = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
//                String fileName = "C:\\Users\\B2\\Desktop\\1.txt";
        ArrayList<String> arr = $.readFileData(fileName);
        arr.forEach((value) -> {
            int count = 0;
            for(String a: words
                ) {
                count += $.getCountValInString(a, value);
            }
            if(count==2){
                System.out.println(value);
            }
        });



    }

        private int getCountValInString(String compareValue, String str){
            int count = 0;
            Pattern pattern = Pattern.compile("\\b" + compareValue + "\\b");
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()){
                ++count;
            }
            return count;
        }

        private ArrayList<String> readFileData (String fileName) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            ArrayList<String> filedataContainer = new ArrayList<>();
            while (bufferedReader.ready()) {
                filedataContainer.add(bufferedReader.readLine());
            }
            bufferedReader.close();
            return filedataContainer;

        }
}
