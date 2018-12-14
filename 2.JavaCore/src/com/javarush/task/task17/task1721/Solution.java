package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args){
        String fileNameFirst = "";
//        String fileNameFirst = "C:\\Users\\B2\\Desktop\\first.txt";
//        String fileNameSecond = "C:\\Users\\B2\\Desktop\\second.txt";
        String fileNameSecond = "";
        String str;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            fileNameFirst = br.readLine();
            fileNameSecond = br.readLine();
        }
        catch (IOException e){}

        File fileFirst = new File(fileNameFirst);
        File fileSecond = new File(fileNameSecond);

        try(BufferedReader br = new BufferedReader(new FileReader(fileFirst))){
            while ((str = br.readLine()) != null){
                allLines.add(str);
            }
        }
        catch (Exception e){}

        try(BufferedReader br = new BufferedReader(new FileReader(fileSecond))){
            while ((str = br.readLine()) != null){
                forRemoveLines.add(str);
            }
        }
        catch (Exception e){}

        try {
            new Solution().joinData();
        }catch (CorruptedDataException e){}
    }

    public void joinData () throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }else{
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
