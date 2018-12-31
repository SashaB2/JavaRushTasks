package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(
                new BufferedReader(new InputStreamReader(System.in)).readLine())));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("1.txt")));
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready())
            stringBuilder.append(bufferedReader.readLine());
        String [] source = stringBuilder.toString().split("[ \\r\\n]");
        StringBuilder result = getLine(source);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();
        if(words.length == 0 || words[0].isEmpty()){
            return stringBuilder.append("");
        }
        SortedSet<String> uniqueWords = new TreeSet<>();
        uniqueWords.addAll(Arrays.asList(words));
        String [] wordss = new String [uniqueWords.size()];
        uniqueWords.toArray(wordss);
        ArrayList<StringBuilder> examples = new ArrayList<>();


        for(String exp : uniqueWords) {
            stringBuilder.append(exp);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(exp);

            for(String word : uniqueWords) {
                String lastLetter = Character.toString(stringBuilder.charAt(stringBuilder.length()-1));

                for(String word2 : uniqueWords) {
                    if(word2.toUpperCase().startsWith(lastLetter.toUpperCase()) && !arrayList.contains(word2)){
                        stringBuilder.append(" " + word2);
                        arrayList.add(word2);
                        break;
                    }
                }
            }
            arrayList.clear();

            if(examples.size() == 0){
                examples.add(stringBuilder);
            }else if(examples.get(0).length() < stringBuilder.length()){

                    examples.clear();
                    examples.add(stringBuilder);
            }
                stringBuilder  = new StringBuilder();
            }
        return examples.get(0);
    }
}
