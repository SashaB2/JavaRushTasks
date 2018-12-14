package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {

    private LinkedList<String> filedataContainer = new LinkedList<>();
    private Map<String, Double> notSortedValues = new HashMap<>();
    private Map<String, Double> mapWithBiggesValues = new HashMap<>();




    public static void main(String[] args) throws IOException {
        Solution $ = new Solution();
        String fileName = args[0];
//        String fileName = "C:\\Users\\B2\\Desktop\\1.txt";
        $.filedataContainer = $.readFileData(fileName);
        $.notSortedValues = $.getDestelatedData($.filedataContainer);
        $.mapWithBiggesValues = $.getTheBiggestValues($.notSortedValues);
        SortedMap<String, Double> stringDoubleSortedMap = new TreeMap<>($.mapWithBiggesValues);

        stringDoubleSortedMap.forEach((key, value) -> {
            System.out.println(key);
        });
    }

    private Map<String, Double> getTheBiggestValues(Map<String, Double> notSortedMap){
        Map<String, Double> tempMap = new HashMap<>();
        String tempS = "";
        double tempD = Double.MIN_VALUE;
        String tempS1;
        double tempD2;
        for(Map.Entry<String, Double> pair: notSortedMap.entrySet()
            ) {
            tempS1 = pair.getKey();
            tempD2 = pair.getValue();
            if(tempD < tempD2){
                tempS = tempS1;
                tempD = tempD2;
            }
        }
        tempMap.put(tempS, tempD);

        for(Map.Entry<String, Double> pair: notSortedMap.entrySet()
            ) {
            tempS1 = pair.getKey();
            tempD2 = pair.getValue();
            if(tempD == tempD2){
                tempMap.put(tempS1, tempD);
            }
        }

        return tempMap;

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

