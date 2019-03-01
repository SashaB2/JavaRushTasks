package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        pr(e);

//        System.out.println(e.getCause().getCause());
//        System.out.println(e.getCause());
//        System.out.println(e );


    }

    private void pr(Throwable e){
        if(e != null) {
            pr(e.getCause());
        }
        if(e != null){
        System.out.println(e);}

    }

    public static void main(String[] args) {

        new Solution().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));

    }
}
