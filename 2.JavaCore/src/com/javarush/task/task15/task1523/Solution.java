package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {

    public Solution(){}

     Solution(Object o){

     }
    protected Solution(Solution s){}

    private Solution(Object o, Solution s){}

    public static void main(String[] args) {

    }
}

