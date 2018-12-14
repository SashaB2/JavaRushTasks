package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();

        //напишите тут ваш код

        for (int i = 0; i < 4; i++) {

            result.add(new Cat());

        }

        return result;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        HashSet<Dog> result = new HashSet<Dog>();

        //напишите тут ваш код

        for (int i = 0; i < 3; i++) {

            result.add(new Dog());

        }
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        HashSet<Object> result = new HashSet<>();

        result.addAll(cats);
        result.addAll(dogs);


        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код

        Iterator<Cat> iteratorCats = cats.iterator();

        while(iteratorCats.hasNext()){

            pets.remove(iteratorCats.next());

        }




    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код

        for (Object o: pets
             ) {
            System.out.println(o.toString());
        }

    }

    //напишите тут ваш код

    public static class Dog{}
    public static class Cat{}
}
