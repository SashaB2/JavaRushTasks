package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (FileReader fileReader = new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine())) {

            StringBuilder stringBuilder = new StringBuilder();
            int input;
            while ((input = fileReader.read()) != -1) {
                stringBuilder.append((char) input);
            }
            ArrayList<String> arrayString = new ArrayList<>(Arrays.asList(stringBuilder.toString().split("[ \r\n]")));


            for (int i = 0; i < arrayString.size(); i++) {
                for (int j = i + 1; j < arrayString.size(); j++) {
                    String revers = new StringBuilder(arrayString.get(j)).reverse().toString();
                    if (arrayString.get(i).equals(revers)) {
                        Pair pair = new Pair();
                        pair.first = arrayString.get(i);
                        pair.second = arrayString.get(j);
                        result.add(pair);
                        arrayString.remove(i);
                        arrayString.remove(j - 1);
                        i = 0;
                        break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


//        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
////        FileInputStream fileInputStream = new FileInputStream("1.txt");
//        FileInputStream fileInputStream = new FileInputStream(bufferedReader1.readLine());
//        bufferedReader1.close();
//        bufferedReader1 = new BufferedReader(new InputStreamReader(fileInputStream));
//        StringBuilder stringBuilder = new StringBuilder();
//        while (bufferedReader1.ready()){
//            stringBuilder.append(bufferedReader1.readLine() + " ");
//        }
//        bufferedReader1.close();
//        fileInputStream.close();
//
////        Pattern pattern = Pattern.compile("([A-Za-zА-Яа-я])+");
////        Pattern patternRevers;
////        Matcher matcher;
////        Matcher matcherRevers;
////        StringBuilder word = new StringBuilder();
////        Pair pair;
////        List<String> matcherWord = new ArrayList<>();
////        matcher = pattern.matcher(stringBuilder.toString());
////
////        while (matcher.find()){
////            word.append(matcher.group());
////            String notReverted = word.toString();
////            String reverted = word.reverse().toString();
////            word.delete(0, word.length());
////
////            pair = new Pair();
////            pair.first = notReverted;
////            pair.second = reverted;
////
//////            pair = new Pair(notReverted, reverted);
////
////            if(!result.contains(pair) && !matcherWord.contains(notReverted)){
////                patternRevers = Pattern.compile(reverted);
////                matcherRevers = patternRevers.matcher(stringBuilder.toString());
////
////                while(matcherRevers.find()){
//////                    result.add(new Pair(notReverted, matcherRevers.group()));
////                    result.add(pair);
////                    matcherWord.add(matcherRevers.group());
////                    break;
////                }
////            }
////
////            pair = null;
////        }
////
////        for(Pair pait : result) {
////            System.out.println(String.format("%s %s", pait.first, pait.second));
////        }
//
////        String [] text = stringBuilder.toString().split("(\\r|\\t|\\n|\\s|\\uFEFF)+");
//        String [] text = stringBuilder.toString().split(" ");
//        List <String> list = new ArrayList<>();
//
//        for(int i = 0; i < text.length; i++) {
//            String word = text[i];
//            String revertedWord = reverse(word);
//            Pair pair = new Pair();
//            pair.first = word;
//            pair.second = revertedWord;
//
//            for(int j = 0; j < text.length; j++) {
//                if(revertedWord.equals(text[j]) && !result.contains(pair) && !list.contains(word)){
//                    result.add(pair);
//                    list.add(revertedWord);
//                }
//            }
//        }
//
////        for(Pair pait : result) {
////            System.out.println(String.format("%s %s", pait.first, pait.second));
////        }
    }

    public static String reverse(String word){
        return new StringBuilder(word).reverse().toString();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
