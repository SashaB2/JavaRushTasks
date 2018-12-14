package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String file1 = "C:\\Users\\B2\\Desktop\\1.txt";
        String file1 = args[0];
        String file2 = args[1];
//        String file2 = "C:\\Users\\B2\\Desktop\\2.txt";
        BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        String fileLine = "";
//        Pattern pattern = Pattern.compile("(\\b\\w+\\d+\\w+\\b)|(\\b\\w+\\d+\\b)|(\\b\\d+\\w+\\b)|(\\b\\d+\\w+\\d+\\b)");
        Pattern pattern = Pattern.compile("\\b[\\S]*[\\d]+[\\S]*\\b");
        int count = 0;


        while (br.ready()){
            fileLine = br.readLine();
            Matcher match = pattern.matcher(fileLine);
            while (match.find()){
                if(count == 0){
                    bw.write(match.group());
                    ++count;
                }else{
                    bw.write(" " + match.group());
                }
            }

        }
        bw.close();
        br.close();
    }


}
