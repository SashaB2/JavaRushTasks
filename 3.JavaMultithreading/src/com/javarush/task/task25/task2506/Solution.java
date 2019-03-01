package com.javarush.task.task25.task2506;

/* 
Мониторинг состояния нити
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);
        loggingStateThread.setDaemon(true);
        loggingStateThread.start(); //NEW
        Thread.sleep(100);
        target.start();  //RUNNABLE
        Thread.sleep(100);
        //TERMINATED
    }
}

class LoggingStateThread extends Thread{

    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
//        setDaemon(true);
    }

    @Override
    public void run() {
        State state = thread.getState();
        System.out.println(state);
        do{
            if(state != thread.getState()){
                state = thread.getState();
                System.out.println(state);
            }
        }while (thread.getState() != State.TERMINATED);
    }
}