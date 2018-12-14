package com.javarush.task.task08.task0819;

import javax.swing.text.html.HTMLDocument;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();


        //напишите тут ваш код. step 3 - пункт 3
        Iterator<Cat> iterator = cats.iterator();

        while(iterator.hasNext()){
            Cat c = iterator.next();
            cats.remove(c);
            break;
        }

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        HashSet<Cat> cats = new HashSet<>();

        Cat c = new Cat();

        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4

//        Iterator<Cat> iterator = cats.iterator();

        for (Cat c: cats
             ) {
            System.out.println(c.toString());
        }
    }

    // step 1 - пункт 1
    public static class Cat{

    }
}
