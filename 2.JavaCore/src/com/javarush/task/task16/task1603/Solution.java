package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread specialThread = new SpecialThread();
        SpecialThread specialThread1 = new SpecialThread();
        SpecialThread specialThread2 = new SpecialThread();
        SpecialThread specialThread3 = new SpecialThread();
        SpecialThread specialThread4 = new SpecialThread();

        Thread t = new Thread(specialThread);
        Thread t1 = new Thread(specialThread1);
        Thread t2 = new Thread(specialThread2);
        Thread t3 = new Thread(specialThread3);
        Thread t4 = new Thread(specialThread4);


       list.add(t);
       list.add(t1);
       list.add(t2);
       list.add(t3);
       list.add(t4);

//        for (Thread tt : threadList) {
//            tt.start();
//        }

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
