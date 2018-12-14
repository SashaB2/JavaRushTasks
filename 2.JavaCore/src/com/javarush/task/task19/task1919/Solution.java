package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    private LinkedList<String> filedataContainer = new LinkedList<>();
    private Map<String, Double> notSortedValues = new HashMap<>();
    private Map<String, Double> SortedValues = new HashMap<>();
    
    


    public static void main(String[] args) throws IOException {
        Solution $ = new Solution();
        String fileName = args[0];
//        String fileName = "C:\\Users\\B2\\Desktop\\1.txt";
        $.filedataContainer = $.readFileData(fileName);
        $.notSortedValues = $.getDestelatedData($.filedataContainer);
        SortedMap<String, Double> stringDoubleSortedMap = new TreeMap<>($.notSortedValues);

        stringDoubleSortedMap.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }

    private LinkedList<String> readFileData(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()){
            filedataContainer.add(bufferedReader.readLine());
        }
        bufferedReader.close();
        return filedataContainer;

    }

    private Map<String, Double> getDestelatedData(LinkedList<String> fileContent){
        String name;
        double value;
        String [] tempLine;
        Map<String, Double> notSortedValues = new HashMap<>();
        for(String line: fileContent) {
            tempLine = line.split(" ");
            name = tempLine[0];
            value = Double.parseDouble(tempLine[1]);
            if(notSortedValues.containsKey(name)){
                double tempValue = notSortedValues.get(name);
                notSortedValues.put(name, tempValue + value);
            }else{
                notSortedValues.put(name, value);
            }

        }
        return notSortedValues;
    }

}
