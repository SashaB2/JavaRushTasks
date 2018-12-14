package com.javarush.task.task19.task1921;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public final static List<Person> PEOPLE = new ArrayList<Person>();
    private ArrayList<String> filedataContainer = new ArrayList<>();
    private Map<String, Double> notSortedValues = new HashMap<>();
    private Map<String, Double> mapWithBiggesValues = new HashMap<>();



    public static void main(String[] args) throws IOException {
        Solution $ = new Solution();
        String fileName = args[0];
//        String fileName = "C:\\Users\\B2\\Desktop\\1.txt";
        $.filedataContainer = $.readFileData(fileName);
//        $.notSortedValues = $.getDestelatedData($.filedataContainer);
        $.getParsedvalues($.filedataContainer);

//        PEOPLE.forEach((value) ->{
//            System.out.println(value.getName() + " | " + value.getBirthDate());
//        });

    }




    private void getParsedvalues(ArrayList<String> list){
        ArrayList<Person> tempList = new ArrayList<>();
//        Date date = new Date();
        Pattern patternName = Pattern.compile("^\\D+");
        Pattern patternDate = Pattern.compile("\\d+");
        list.forEach((value) -> {
            String name = "";
            Matcher matcher = patternName.matcher(value);
            while (matcher.find()){
                String temp = matcher.group();
                name = temp.substring(0, temp.length() -1);
            }
            Matcher matcher1 = patternDate.matcher(value);
            ArrayList<Integer> tempList1 = new ArrayList<>();
            while (matcher1.find()){
                int tempVal = Integer.parseInt(matcher1.group());
                tempList1.add(tempVal);
            }

            LocalDate localDate = LocalDate.of(tempList1.get(2), tempList1.get(1), tempList1.get(0));
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }


//            date.setDate(tempList1.get(0));
//            date.setMonth(tempList1.get(1));
//            date.setYear(tempList1.get(2));
            PEOPLE.add(new Person(name, date));

        });

//        return tempList;
    }

//    private Map<String, Double> getTheBiggestValues(Map<String, Double> notSortedMap){
//        Map<String, Double> tempMap = new HashMap<>();
//        String tempS = "";
//        double tempD = Double.MIN_VALUE;
//        String tempS1;
//        double tempD2;
//        for(Map.Entry<String, Double> pair: notSortedMap.entrySet()
//                ) {
//            tempS1 = pair.getKey();
//            tempD2 = pair.getValue();
//            if(tempD < tempD2){
//                tempS = tempS1;
//                tempD = tempD2;
//            }
//        }
//        tempMap.put(tempS, tempD);
//
//        for(Map.Entry<String, Double> pair: notSortedMap.entrySet()
//                ) {
//            tempS1 = pair.getKey();
//            tempD2 = pair.getValue();
//            if(tempD == tempD2){
//                tempMap.put(tempS1, tempD);
//            }
//        }
//
//        return tempMap;
//
//    }

    private ArrayList<String> readFileData(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()){
            filedataContainer.add(bufferedReader.readLine());
        }
        bufferedReader.close();
        return filedataContainer;

    }

//    private Map<String, Double> getDestelatedData(LinkedList<String> fileContent){
//        String name;
//        double value;
//        String [] tempLine;
//        Map<String, Double> notSortedValues = new HashMap<>();
//        for(String line: fileContent) {
//            tempLine = line.split(" ");
//            name = tempLine[0];
//            value = Double.parseDouble(tempLine[1]);
//            if(notSortedValues.containsKey(name)){
//                double tempValue = notSortedValues.get(name);
//                notSortedValues.put(name, tempValue + value);
//            }else{
//                notSortedValues.put(name, value);
//            }
//
//        }
//        return notSortedValues;
//    }

}

