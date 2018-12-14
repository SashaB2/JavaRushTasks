package com.javarush.task.task08.task0828;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        HashMap<Integer, String> monthsMap = new HashMap<>();

        Date now = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("M, MMMM ");
        int count = 0;
        String [] tempContainer = new String[2];

        while(count <= 11){
            now.setMonth(count);
            tempContainer = dateFormatter.format(now).split(", ");
            monthsMap.put(Integer.parseInt(tempContainer[0]),tempContainer[1].substring(0, tempContainer[1].length()-1));
//            System.out.println(dateFormatter.format(now));
            ++count;
        }


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameMonth = reader.readLine();

        for (Map.Entry<Integer, String> pair: monthsMap.entrySet()
                ) {



            if(pair.getValue().equals(nameMonth)){
                System.out.println(pair.getValue() + " is the " +pair.getKey() + " month");
                break;
            }

        }




    }
}
