package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));



                Integer a = Integer.parseInt(reader.readLine());
                Integer b = Integer.parseInt(reader.readLine());

                if(a <= 0 || b <= 0) throw new Exception();

                while (a!=0 && b!=0){

                    if(a> b){
                        a = a%b;
                    }else{
                        b=b%a;
                    }

                }
        System.out.println(a+b);

            int max, min, temp;

            max = (a>=b)?a:b;
            min = (a<=b)?a:b;
            temp = min;


            while(temp != 0){

                if(min%temp == max%temp ){

                    System.out.println(temp);
                    break;

                }else if(temp == 1){
                    System.out.println(temp);
                    break;
                }
                else{
                    --temp;
                }
            }





    }
}
