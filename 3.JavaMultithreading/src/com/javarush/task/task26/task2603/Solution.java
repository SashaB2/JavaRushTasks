package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {
        Test t1 = new Test("c", 3);
        Test t2 = new Test("c", 1);
        Test t3 = new Test("c", 2);

        ArrayList<Test> at = new ArrayList<>();
        at.add(t1);
        at.add(t2);
        at.add(t3);

        Collections.sort(at, new CustomizedComparator<>(new Comparator<Test>() {

            @Override
            public int compare(Test o1, Test o2) {
                return o1.x.compareTo(o2.x);
            }
        },new Comparator<Test>() {

            @Override
            public int compare(Test o1, Test o2) {
                return o1.y- o2.y;
            }
        }
        ));

        for (Test test: at) {
            test.consoleOut();
        }
    }

    public static class CustomizedComparator<T> implements Comparator<T>{
        private Comparator<T> comparators [];

        public CustomizedComparator(Comparator<T>... varargs) {
            if(varargs.length == 0) return;
            this.comparators = varargs;
        }



        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator comparator : comparators) {
                result = comparator.compare(o1, o2);
                if (result != 0) break;
            }
            return result;
        }
    }

    //TDD
    static class Test{
        private String x;
        private int y;

        public Test(String x, int y) {
            this.x = x;
            this.y = y;
        }

        public void consoleOut(){
            System.out.println(x + "|" + y );
        }
    }
}
