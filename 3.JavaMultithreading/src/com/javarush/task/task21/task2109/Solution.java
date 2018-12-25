package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof A)) return false;

            A a = (A) o;
            return Objects.equals(i, a.i) &&
                    Objects.equals(j, a.j);
        }

        @Override
        public int hashCode(){
            return Objects.hash(i, j);
        }

        @Override
        public A clone() throws CloneNotSupportedException {
            A a = new A(getI(), getJ());
            return a;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
//            B b = new B(getI(), getJ(), getName());
//            return b;
        }

        @Override
        public int hashCode(){
            return Objects.hash(name);
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof B)) return false;

            B b = (B)o;

            return Objects.equals(name, b.name);
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public C clone(){
            return new C(getI(), getJ(), getName());
        }
    }

    public static void main(String[] args) {

    }
}
