package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode( ) {
            final String[] countryCode = new String[1];

            countries.forEach((key, value) -> {
                if(customer.getCountryName().equals(value)){
                    countryCode[0] = key;
                }
            });

            return countryCode[0];
        }

        @Override
        public String getCompany( ) {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName( ) {
            return contact.getName().split(" ")[1];
        }

        @Override
        public String getContactLastName( ) {
            String pasedString =  contact.getName().split(" ")[0];
            String lastName = pasedString.substring(0, pasedString.length() - 1);


            return lastName;
        }

        @Override
        public String getDialString( ) {
            String beforeAdjustString = contact.getPhoneNumber();
            String plusParth = "\\+";
            String numberParth = "[0-9]+";
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < beforeAdjustString.length(); i++) {
                if(Character.toString(beforeAdjustString.charAt(i)).matches(plusParth) || Character.toString(beforeAdjustString.charAt(i)).matches(numberParth)){
                    temp.append(beforeAdjustString.charAt(i));
                }
            }


            return "callto://" + temp.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}