package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        String a = "5";
        String b = "6";


        m(a);
        m(b);
    }

    static void m(String a){
        T t = new T();
        t.setA(a);
    }

    static class T extends Thread{

        String a;

        T(){
        }

        public void setA(String a){
            this.a = a;
        }

        @Override
        public void run( ) {
            System.out.println(a);
        }
    }
}
