package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new ThreadFirst());
        threads.add(new ThreadSecond());
        threads.add(new ThreadThird());
        threads.add(new ThreadFourth());
        threads.add(new ThreadFifth());
    }
    public static void main(String[] args) {

    }

    public static class ThreadFirst extends Thread{
        public void run(){
            while(true){}
        }
    }

    public static class ThreadSecond extends Thread{
        public void run(){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadThird extends Thread{
        public void run(){
            while(true){
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadFourth extends Thread implements Message{

        @Override
        public void showWarning() {
            this.interrupt();
        }

        public void run(){

            while (!this.isInterrupted()){
            }
        }
    }

    public static class ThreadFifth extends Thread{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        public void run(){

            long a = 0;
            String b;
            while(true){
                b = sc.next();
                if(b.equals("N")) break;
                a += Integer.parseInt(b);
            }
            System.out.println(a);

        }
    }
}

