package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();



    }

   StackTraceElement [] stackTraceElement = Thread.currentThread().getStackTrace();

    public static String method1() {
        method2();
        //напишите тут ваш код

        return Thread.currentThread().getStackTrace()[2].getMethodName();

    }

    public static String method2() {
        method3();
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method3() {
        method4();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method4() {
        method5();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method5() {
        //напишите тут ваш код

        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
