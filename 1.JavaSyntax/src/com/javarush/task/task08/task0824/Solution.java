package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human firstChild = new Human("firstChild", false, 12);
        Human secondChild = new Human("secondChild", true, 12);
        Human thirdChild = new Human("thirdChild", false, 12);
        ArrayList<Human> children = new ArrayList<>();
        children.add(firstChild);
        children.add(secondChild);
        children.add(thirdChild);

        Human mother = new Human("mother", false, 42, children);
        Human father = new Human("father", true, 44, children);

        ArrayList<Human> grandMother = new ArrayList<>();
        ArrayList<Human> grandFather = new ArrayList<>();

        grandFather.add(father);
        grandMother.add(mother);

        Human grandpaMother = new Human("grandpaMother", true, 82, grandMother);
        Human grandpaFather = new Human("grandpaFather", true, 81, grandFather);
        Human grandmaFather = new Human("grandpaFather", true, 84, grandFather);
        Human grandmaMother = new Human("grandpaMother", true, 83, grandMother);

        System.out.println(firstChild);
        System.out.println(secondChild);
        System.out.println(thirdChild);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(grandpaFather);
        System.out.println(grandpaMother);
        System.out.println(grandmaFather);
        System.out.println(grandmaMother);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;
        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
            children = new ArrayList<>();

        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
