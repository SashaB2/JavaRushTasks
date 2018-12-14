package com.javarush.task.task16.task1626;

import java.util.Date;

public class Solution {
    public static int number = 5;
//    static Date d = new Date();

    public static void main(String[] args) {
//        new Thread(new CountDownRunnable(), "Уменьшаем").start();
//        System.out.println(d.getTime());
        new Thread(new CountUpRunnable(), "Увеличиваем").start();

    }

    public static class CountUpRunnable implements Runnable{
        //Add your code here - добавь код тут
        private int temp = number;
        private int countIndexUp = 1;

        @Override
        public void run(){

            try{

                while(true){
                    Thread.sleep(500);

                    System.out.println(toString());
                    countIndexUp++;
                    if(countIndexUp == 6) {
//                        Date d1 = new Date();
//
//                        System.out.println(d.getTime() - d1.getTime());
                        return;}
                }
            }
            catch (InterruptedException e){}
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }

    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;


        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
