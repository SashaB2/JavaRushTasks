package com.javarush.task.task16.task1628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static volatile AtomicInteger countReadStrings = new AtomicInteger(0);
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //read count of strings
        int count = Integer.parseInt(reader.readLine());

        //init threads
        ReaderThread consolReader1 = new ReaderThread();
        ReaderThread consolReader2 = new ReaderThread();
        ReaderThread consolReader3 = new ReaderThread();

        consolReader1.start();
        consolReader2.start();
        consolReader3.start();

        while (count > countReadStrings.get()) {
        }

        consolReader1.interrupt();
        consolReader2.interrupt();
        consolReader3.interrupt();
        System.out.println("#1:" + consolReader1);
        System.out.println("#2:" + consolReader2);
        System.out.println("#3:" + consolReader3);

        reader.close();
    }

    public static class ReaderThread extends Thread {
        private List<String> result = new ArrayList<String>();

        public void run() {
            //add your code here - добавьте код тут

            while (!isInterrupted()) {//Тут проверяем остановлен ли цикл,хотя тех задании подругому написано было и терял время из за этого
                if (isInterrupted()){//Если вызвано то выходим из цикла
                    break;//
                }
                synchronized (reader) {//Эту штуку у ребят отсюда посмотрел не знаю что это такое но без этого не пропускает валидатор
                    String string = null;//создаем пустую строку
                    try {//
                        if(reader.ready()) {//Без этой проверки на считывание строк валидатор тоже не пропускал
                            string = reader.readLine();//считываем сроки
                            result.add(string);//заносим в лист
                            countReadStrings.incrementAndGet();//вызываем добавления ,
                        }//вызывал схожий метод  и тупил час
                    } catch (IOException e) {//
                        e.printStackTrace();//
                    }


                }
            }
        }

        @Override
        public String toString() {
            return result.toString();
        }
    }
}
