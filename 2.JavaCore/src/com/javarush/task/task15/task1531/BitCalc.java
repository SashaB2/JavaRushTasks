package com.javarush.task.task15.task1531;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BitCalc {
    public static void main(String[] args) {

        LinkedList<Byte> cB = new LinkedList<>();

        int a = 400;

        String b = Integer.toBinaryString(a);



        System.out.println(b);
        System.out.println(" \n");



    }

//    static String multifyBites(HashMap<Long, String> gropB){
//
//
//
//    }

    static HashMap<Long, String> groupByButes(String binaryNumber){

        HashMap<Long, String> grouBinary = new HashMap<>();
        String concat = "";
        long countBites = 0;

        for (int i = 0; i < binaryNumber.length(); i++) {

            concat = Character.toString(binaryNumber.charAt(i));
            grouBinary.put(countBites++, concat);
            concat = null;

//            if(binaryNumber.length() >= 8) {
//                if (concat.length() == 8) {
//
//                    grouBinary.put(++countBites, concat);
//                    concat = null;
//
//                }
//            }
//            if(binaryNumber.length() < 8){
//                grouBinary.put(++countBites, concat);
//            }

        }
            return grouBinary;
    }
}
