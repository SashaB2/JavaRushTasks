package com.javarush.task.task19.task1903;

public class Test {

    public static void main(String[] args) {
//        +38(050)123-45-67
        String cutPhoneNumber = String.valueOf("501234567");

        String zero = "0";
        while(cutPhoneNumber.length()<10){
            cutPhoneNumber = zero + cutPhoneNumber;
        }

        System.out.println(cutPhoneNumber);
        String phoneNumberInBreket1 = cutPhoneNumber.substring(0,3);
        System.out.println(phoneNumberInBreket1);
        String phoneNumberAfterNumberInBreket2 = cutPhoneNumber.substring(3,6);
        System.out.println(phoneNumberAfterNumberInBreket2);
        String phoneNumberAfterNumberInBreket3 = cutPhoneNumber.substring(6,8);
        System.out.println(phoneNumberAfterNumberInBreket3);
        String phoneNumberAfterNumberInBreket4 = cutPhoneNumber.substring(8,10);
        System.out.println(phoneNumberAfterNumberInBreket4);
        System.out.println(String.valueOf("+" + "38" + "(" +  phoneNumberInBreket1 + ")" + phoneNumberAfterNumberInBreket2 + "-" + phoneNumberAfterNumberInBreket3 + "-" + phoneNumberAfterNumberInBreket4));
//            +38(050)123-45-67


    }
}
