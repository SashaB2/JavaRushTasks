package com.javarush.task.task07.task0724;

/* 
Семейная перепись
1. Программа не должна считывать данные с клавиатуры.
2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Human h1 = new Human("дедушка1",true,80);
        Human h2 = new Human("дедушка2",true,81);
        Human h3 = new Human("бабушка1", false, 75);
        Human h4 = new Human("бабушка2", false, 74);
        Human h5 = new Human("папа",true,40, h1, h3);
        Human h6 = new Human("мама", false, 35, h2, h4);
        Human h7 = new Human("one", false, 11, h5, h6);
        Human h8 = new Human("two", false, 12, h5, h6);
        Human h9 = new Human("three", false, 12, h5, h6);

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
        System.out.println(h5);
        System.out.println(h6);
        System.out.println(h7);
        System.out.println(h8);
        System.out.println(h9);
    }

    public static class Human {
        //напишите тут ваш код

        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















