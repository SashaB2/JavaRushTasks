package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
       HashMap<String, Cat> cats = new HashMap<>();
        cats.put("asd1", new Cat("sdjghfsd1"));
        cats.put("asd2", new Cat("sdfsghjd2"));
        cats.put("asd3", new Cat("sdghfsd3"));
        cats.put("asd4", new Cat("sddfgjfsd4"));
        cats.put("asd5", new Cat("sddfgghjfs5d"));
        cats.put("asd6", new Cat("sdgfhjfs6d"));
        cats.put("asd7", new Cat("sdgfs7d"));
        cats.put("asd8", new Cat("dfsdfsd8"));
        cats.put("asd9", new Cat("sdfxb9sd"));
        cats.put("asd10", new Cat("sdf0sd"));

        return cats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        HashSet<Cat> cats = new HashSet<>();

        for (Map.Entry<String, Cat> pair: map.entrySet()
             ) {
            cats.add(pair.getValue());
        }

        return cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
