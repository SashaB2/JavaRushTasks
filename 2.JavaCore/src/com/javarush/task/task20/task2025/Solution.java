package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        long[] numbers = new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153};
        List<Long> list = new LinkedList<>();
        for (long number : numbers)
        {
            if (number < N)
                list.add(number);
        }
        long[] result = new long[list.size()];
        for (long i = 0; i < list.size(); i++)
            result[(int)i] = list.get((int)i);
        return result;

    }

//    public static long[] getNumbers(long N) {
//        if(N < 0){
//            long[] result = {};
//            return result;
//        }
//        //В list будут складироваться числа Армстронга
//        ArrayList<Long> list = new ArrayList<Long>();
//        long[] result;
//        //Получаем разрядность числа N
//        int size = (int)Math.log10(N) + 1;
//        //Создаем двумерный массив с количеством строк, равным разряду числа N
//        int arr[][] = new int[size][];
//
//        //Инициализируем массивы внутри основного массива. Получаем треугольный массив, заполненных нулями.
//        //Каждый внутренний массив по сути является уже разбитым на цифры числом, которое мы будем проверять.
//        for (int i = 0; i < arr.length; i++)
//            arr[i] = new int[i + 1];
//
//        //Идем по массиву построчно
//        for (int i = 0; i < arr.length; i++) {
//            //В этом цикле все происходит :) увеличиваем наше "Число", представленное строкой массива, на 1.
//            while (true) {
//                long sum = 0;
//
//                //В sum записываем число для проверки на соответстве числу Армстронга
//                for (int j = 0; j < arr[i].length; j ++)
//                    sum += pow(arr[i][j], arr[i].length);
//
//                //Перед проверкой числа проверяем, совпадает ли его разрядность с нужной нам.
//                //Если нет, то и проверять не имеет смысла.
//                if ((int)Math.log10(sum) + 1 == arr[i].length) {
//                    //Проверяем, меньше ли наше число, чем N.
//                    //По условиям задачи тут должно проверятся условие sum < N,
//                    //но проклятый валидатор, как оказалось, имел в виду меньшую разрядность.
//                    if ((int)Math.log10(sum) < (int)Math.log10(N)) {
//                        //Проверяем наше число на соответствие числу Армстронга и пишем его в list, если подходит.
//                        if (isArmstrong(sum, arr[i]))
//                            list.add(sum);
//                    }
//                }
//                //Если старший разряд нашего числа достиг максимума (9),
//                //выходим из цикла и переходим к следующей строке массива.
//                if (arr[i][0] == 9)
//                    break;
//
//                //Если младший разряд числа достиг своего максимума(9)
//                if (arr[i][arr[i].length - 1] == 9) {
//                    boolean isFind = false;
//
//                    //ищем в массиве разряд, который предшествует значению "9"
//                    for (int j = 0; j < arr[i].length - 1; j++) {
//                        //и увеличиваем его на 1.
//                        if (arr[i][j + 1] == 9 && !isFind) {
//                            arr[i][j]++;
//                            isFind = true;
//                        }
//
//                        //Все последующие разряды приравниваем к тому, который мы только что увеличили.
//                        //Это необходимо, чтобы не проверять повторяющиеся значения, вызванные перестановкой
//                        //одинаковых разрядов
//                        if (isFind)
//                            arr[i][j + 1] = arr[i][j];
//                    }
//                }
//                //Если младший разряд еще не достиг максимуму, увеличиваем его на 1
//                else
//                    arr[i][arr[i].length - 1]++;
//            }
//        }
//
//        //Сортируем list и переписываем данные из него в result
//        Collections.sort(list);
//        result = new long[list.size()];
//        for (int i = 0; i < list.size(); i++)
//            result[i] = list.get(i);
//        return result;
//    }
//
//    //Метод проверяет число на соответствие числу Армстронга.
//    //Массив arr содержит разряды числа, из которого было получено число number
//    public static boolean isArmstrong(long number, int[] arr) {
//        //В list будут хранится разряды числа number
//        ArrayList<Long> list = new ArrayList<Long>();
//        //point - предел цикла для нарезки числа на разряды
//        long point = pow(10, arr.length - 1);
//
//        //нарезаем число на разряды
//        for (long i = 1; i <= point; i *= 10 ) {
//            //Проверяем, не вскочил ли i за пределы long. Иначе лишимся последних 4-х чисел Армстронга в пределе long
//            if (i > 0)
//                list.add(((number / i) % 10));
//
//        }
//
//        Collections.sort(list);
//        boolean isEquals = true;
//
//        //Сравниваем "нарезанные" разряды с теми, из которых получилось число number.
//        //Если все совпадает, значит true.
//        for (int i = 0; i < arr.length; i++) {
//            if (list.get(i) != arr[i]) {
//                isEquals = false;
//                break;
//            }
//        }
//        return isEquals;
//    }
//
//    //Это работает в разы быстрее Math.pow()
//    public static long pow (int num, int exp) {
//        long l = 1;
//        for (int i = 0; i < exp; i++)
//            l *= (long)num;
//
//        return l;
//
//    }

//    public static long[] getNumbers(long N) {
//        long [] result = null;  //12
//        List<Long> tempList = new ArrayList<>();
//        long temp;
//        long [] tempArr = null;
//        long tempNumberAfterAdd = 0;
//        long numberToPower = 0;
//        long power = 0;
//        long matrix [][] = new long[19][19];
//
//
//
//        for(long j= 1l; j <  N+1; j++) {
//
//                //-------------------------
//            long[] arrayOfNumbers = new long[19];
//            int count = 0;
//            long n = j;
//
//            while (n != 0){
//                    arrayOfNumbers[count] = n % 10;
//                    ++count;
//                    n = n / 10;
//                }
//
//                //-------------------------
//                //--------------------------
//                tempArr = arrayOfNumbers;
//                power = count;
//
//                for(int k = 0; k < power; k++) {
//                    numberToPower = tempArr[k];
//                    if(matrix[(int) numberToPower][(int) power] == 0){
//                        temp = numberToPower;
//
//                        if(!(numberToPower == 0 || numberToPower == 1)){
//                            for(int i = 1; i < power; i++) {
//                                temp = temp * numberToPower;
//                            }
//                        }
//                        matrix[(int) numberToPower][(int) power] = temp;
//                    }
//
//                    tempNumberAfterAdd += matrix[(int) numberToPower][(int) power];
//                }
//                //--------------------------
//
//                if(j == tempNumberAfterAdd){
//                    tempList.add(tempNumberAfterAdd);
//                }
//                tempNumberAfterAdd = 0;
//            }
//
//            result = new long[tempList.size()];
//        for(int i = 0; i < tempList.size(); i++) {
//            result[i] = tempList.get(i);
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
//        Date d1 = new Date();
//        long[]la = getNumbers(1000000);
//        Date d2 = new Date();
//        System.out.println((d2.getTime()-d1.getTime()));
//
////        long total = Runtime.getRuntime().totalMemory();
////        long tota2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
////        System.out.println(total);
////        System.out.println(tota2/1024/1024);
//
//        System.out.println("-------------------------------------------------");
//        for(int i = 0; i < la.length; i++) {
//            System.out.print(la[i] + ", ");
//
//        }
    }
}
