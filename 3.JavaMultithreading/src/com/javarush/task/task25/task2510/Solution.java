package com.javarush.task.task25.task2510;

/*
Поживем - увидим
*/
public class Solution extends Thread implements Thread.UncaughtExceptionHandler{

    public Solution() {
        setUncaughtExceptionHandler(this);
    }

    public static void  main(String[] args) {
        new Solution().start();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if(e instanceof Error){
            System.out.println("Нельзя дальше работать");
        }else if(e instanceof Exception){
            System.out.println("Надо обработать");
        }else if(e instanceof Throwable){
            System.out.println("Поживем - увидим");
        }
    }

//    @Override
//    public void run(){
//        throw new NullPointerException("qqqqqqqqqqqqqqqqqqq");
//    }
}
