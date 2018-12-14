package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private byte byt;
        private short shor;
        private int intege;
        private long lon;
        private float flo;
        private double doubl;

        public Human(double doubl, float flo, long lon, int intege) {
            this.doubl = doubl;
            this.flo = flo;
            this.lon = lon;
            this.intege = intege;
        }

        public Human(double doubl, float flo, long lon) {
            this.doubl = doubl;
            this.flo = flo;
            this.lon = lon;
        }

        public Human(double doubl, float flo) {
            this.doubl = doubl;
            this.doubl = doubl;
        }

        public Human(double doubl) {
            this.doubl = doubl;
        }

        public Human(float flo){
            this.flo = flo;
        }

        public Human(long lon){
            this.lon = lon;
        }

        public Human(){}
        public Human(byte byt){
            this.byt = byt;
        }
        public Human(short shor){
            this.shor = shor;
        }

        public Human(int intege){
            this.intege = intege;
        }
    }
}
