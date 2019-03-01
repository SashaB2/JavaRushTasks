package com.javarush.task.task25.task2505;

/* 
Без дураков
*/
public class Solution {

    public static void main(String[] args) {
        Thread myThread = new Solution().new MyThread("super secret key");
//        Thread thread = new Thread(myThread);
//        thread.run();
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(false);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
//                    System.out.println(secretKey + ", " + t.getName() + ", " + e.getMessage());
                    System.out.println(String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage()));
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }



}

