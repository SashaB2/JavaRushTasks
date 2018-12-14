package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
//        args = new String[]{"-d", "0", "1"};
        SimpleDateFormat sf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sf2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int id;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for(int i = 1; i < args.length; i+=3) {

                        if(args[i+1].equals("м")){
                            try {
                                allPeople.add(Person.createMale(args[i], sf1.parse(args[i+2])));
                                System.out.println(allPeople.size() - 1);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                allPeople.add(Person.createFemale(args[i], sf1.parse(args[i+2])));
                                System.out.println(allPeople.size() - 1);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for(int i = 1; i < args.length; i+=4) {
                        id = Integer.parseInt(args[i]);
                        if(args[i+2].equals("м")){
                            try {
                                allPeople.set(id, Person.createMale(args[i+1], sf1.parse(args[i+3])));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                allPeople.set(id, Person.createFemale(args[i+2], sf1.parse(args[i+3])));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for(int i = 1; i < args.length; i++) {
                        id = Integer.parseInt(args[i]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDay(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for(int i = 1; i < args.length; i++) {
                    id = Integer.parseInt(args[i]);
                    String name = allPeople.get(id).getName();
                    String sex = allPeople.get(id).getSex().equals(Sex.MALE) ? "м" : "ж";
                    System.out.printf("%s %s %s", name, sex, sf2.format(allPeople.get(id).getBirthDay()));
                        System.out.println();
                    }

                }
                break;
        }
        //start here - начни тут

    }
}
