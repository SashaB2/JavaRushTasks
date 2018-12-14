package com.javarush.task.task15.task1531;

public class TestThread {

    public static void main(String[] args) {

        Tss t = new Tss();
        Thread childTh = new Thread(t);
        childTh.start();
        System.out.println("test2");

        Tss t1 = new Tss();
        Thread childTh1 = new Thread(t1);
        childTh1.start();



    }


}

class Tss implements Runnable{

    @Override
    public void run() {
        System.out.println("test1");
    }
}
