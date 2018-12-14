package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        boolean trigger = false;
        HashSet<Integer> set1 = new HashSet<Integer>();

        for (int i = 0; i < 20; i++) {
            int b = (int)Math.ceil(Math.random()*300) + 1 * -100;

            for (int c: set1
                 ) {
                if(b == c){
                    --i;
                    trigger = true;
                    break;
                }

            }

            if(trigger == true){
                trigger = false;
            }else{
                set1.add(b);

            }


        }


        return set1;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код

        Iterator<Integer> iterator = set.iterator();

       while(iterator.hasNext()){
           if(iterator.next() > 10){
               iterator.remove();
           }
       }
        return set;
    }

    public static void main(String[] args) {


    }
}
