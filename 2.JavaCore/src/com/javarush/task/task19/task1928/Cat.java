package com.javarush.task.task19.task1928;

import java.io.*;

public class Cat {
    public String name;
    public int age;
    public int weight;

    public void save(PrintStream writer){
        writer.println(name);
        writer.println(age);
        writer.println(weight);
        writer.flush();
    }

    public void load(BufferedReader reader)throws  Exception{
        name =reader.readLine();
        age = Integer.parseInt(reader.readLine());
        weight = Integer.parseInt(reader.readLine());
    }

    public static void main(String[] args) throws Exception {
        Cat c = new Cat();
        c.name="asd";
        c.age=21;
        c.weight=54;
        c.save(new PrintStream("1.txt"));

        Cat c1 = new Cat();
        c1.load(new BufferedReader(new FileReader("1.txt")));
        System.out.println(c1.name);
    }

}

class Dog{
    public String name;
    public int age;

    public void save(PrintStream writer){
        writer.println(name);
        writer.println(age);
        writer.flush();
    }
    public void load(BufferedReader reader)throws  Exception{
        name =reader.readLine();
        age = Integer.parseInt(reader.readLine());
    }

}

class Human{
    public Cat cat;
    public Dog dog;

    public void save(PrintStream printStream){
        String isCatPresent = cat!=null?"yes":"no";
        printStream.println(isCatPresent);
        printStream.flush();
        if(cat != null) cat.save(printStream);

        String isDogPresent = dog!=null?"yes":"no";
        printStream.println(isCatPresent);
        printStream.flush();
        if(dog != null) dog.save(printStream);
    }

    public void load(BufferedReader bufferedReader) throws Exception {
            String isCatPresent = bufferedReader.readLine();
            if(isCatPresent.equals("yes")){
                cat = new Cat();
                cat.load(bufferedReader);
            }
            String isDogPresent = bufferedReader.readLine();
            if(isCatPresent.equals("no")){
                dog = new Dog();
                dog.load(bufferedReader);
            }
    }
}
