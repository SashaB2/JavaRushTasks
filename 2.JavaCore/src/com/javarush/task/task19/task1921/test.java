package com.javarush.task.task19.task1921;

public class test {
    public static void main(String[] args) {
        String a = "first second third 10 12 1098";

//        PEOPLE.add(new Person(personInfo.get(i).substring(0, personInfo.get(i).replaceFirst("^(\\D+).*$", "$1").length() - 1), new SimpleDateFormat("dd MM yyyy").parse(personInfo.get(i).substring(personInfo.get(i).replaceFirst("^(\\D+).*$", "$1").length(), personInfo.get(i).length()))));

        System.out.println(a.replaceFirst("^(\\D+).*$", "$1").length()-1);
        System.out.println(a.replaceFirst("^(\\D+).*$", "$1"));



        System.out.println(a.substring(0, a.replaceFirst("^(\\D+).*$", "$1").length() - 1));
    }
}
