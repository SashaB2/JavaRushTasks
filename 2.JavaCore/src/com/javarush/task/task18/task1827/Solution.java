package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    final int IdQuantitySymbols = 8;

    final int ProductNameQuantitySymbols = 30;

    final int PriceQuantitySymbols = 8;

    final int QuantytyGoodsQuantitySymbols = 4;

    final String CommanForAddingNewItemToTheList = "-c";

    final int totalLengs = IdQuantitySymbols + PriceQuantitySymbols + ProductNameQuantitySymbols + QuantytyGoodsQuantitySymbols;

    public static void main(String[] args) throws Exception {

        String readLine = "";

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            readLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String finalAddedLine;

        String commandType;
        String productName;
        String price;
        String quotity;

        if(args.length == 0){

            commandType = "";
            productName = "";
            price = "";
            quotity = "";
        }else {

            commandType = args[0];
            productName = args[1];
            price = args[2];
            quotity = args[3];
        }
//        commandType = "-c";
//        productName = "qwe";
//        price = "12345678";
//        quotity = "1234";



        if(commandType.equals("-c")){
            finalAddedLine = paramMaker(String.valueOf(findId(readLine) + 1), 8) + paramMaker(productName, 30) + paramMaker(price, 8) + paramMaker(quotity, 4);
            addValueToTheFile(readLine, finalAddedLine);
        }

    }

    static String paramMaker(String param, int maxLenth){
        for(int i = param.length(); i < maxLenth; i++) {
            param+= " ";
        }
        return param;
    }



    static void addValueToTheFile(String fileName, String addedItem){
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName, true));

            byte[]bytes = ("\n"+addedItem).getBytes();
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int findId(String fileName) {

        ArrayList<String> arr = new ArrayList<>();
        ArrayList<Integer> idList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while(bufferedReader.ready()) {
                String temp = bufferedReader.readLine();
                arr.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String a: arr
            ) {
            idList.add(Integer.parseInt(a.substring(0,8).trim()));
        }

        int b1 = 0;


        for(int a: idList
            ) {
            if(b1<a){
                b1 = a;
            }
        }

        return b1;

    }
}


