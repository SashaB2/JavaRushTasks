package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
        try {
            PersonScanner personScanner = new PersonScannerAdapter(new Scanner(new File("C:\\Users\\B2\\Desktop\\first.txt")));
            Person person = personScanner.read();
            System.out.println(person);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read( ) throws IOException, ParseException {


            String readLine = this.fileScanner.nextLine();
            String [] arrrreadLine = readLine.split(" ");
            String personSurname = arrrreadLine[0];
            String personFirstName = arrrreadLine[1];
            String personMiddleName = arrrreadLine[2];
            int dayOfBirthday = Integer.valueOf(arrrreadLine[3]);
            int monthOfBirthday = Integer.valueOf(arrrreadLine[4]);
            int yearOfBirthday = Integer.valueOf(arrrreadLine[5]);
            SimpleDateFormat sdf  = new SimpleDateFormat("dd MM yyyy");
            Date dob = sdf.parse(String.format( "%s %s %s", dayOfBirthday, monthOfBirthday, yearOfBirthday));


            return new Person(personFirstName, personMiddleName, personSurname, dob);
        }

        @Override
        public void close( ) throws IOException {
            this.fileScanner.close();
        }
    }
}
