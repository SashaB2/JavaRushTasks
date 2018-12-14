package com.javarush.task.task19.task1903;

/*
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;
        public IncomeDataAdapter(IncomeData incomeData){
            this.data = incomeData;
        }

        @Override
        public String getCompanyName( ) {
            return data.getCompany();
        }

        @Override
        public String getCountryName( ) {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName( ) {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber( ) {
            String cutPhoneNumber = String.valueOf(data.getPhoneNumber());
            String zero = "0";
            while(cutPhoneNumber.length()<10){
                cutPhoneNumber = zero + cutPhoneNumber;
            }


            String phoneNumberInBreket1 = cutPhoneNumber.substring(0,3);
            String phoneNumberAfterNumberInBreket2 = cutPhoneNumber.substring(3,6);
            String phoneNumberAfterNumberInBreket3 = cutPhoneNumber.substring(6,8);
            String phoneNumberAfterNumberInBreket4 = cutPhoneNumber.substring(8,10);



//            +38(050)123-45-67
            return "+" + String.valueOf(data.getCountryPhoneCode()) + "(" +  phoneNumberInBreket1 + ")" + phoneNumberAfterNumberInBreket2 + "-" + phoneNumberAfterNumberInBreket3 + "-" + phoneNumberAfterNumberInBreket4;
        }


    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}