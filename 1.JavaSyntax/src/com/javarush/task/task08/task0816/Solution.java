package com.javarush.task.task08.task0816;

        import java.util.Date;
        import java.util.HashMap;
        import java.util.Iterator;
        import java.util.Map;

/*
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 2010"));
        map.put("Stallone1", new Date("MARCH 2 1980"));
        map.put("Stallone2", new Date("MAY 6 1180"));
        map.put("Stallone3", new Date("OCTOBER 1 1910"));
        map.put("Stallone4", new Date("JANUARY 1 91980"));
        map.put("Stallone5", new Date("AUGUST 1 1980"));
        map.put("Stallone6", new Date("APRIL 30 1980"));
        map.put("Stallone7", new Date("FEBRUARY 1 1981"));
        map.put("Stallone8", new Date("JULY 4 191"));
        map.put("Stallone9", new Date("SEPTEMBER 17 2000"));
        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

//        System.out.println(map.size());

        while(iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
//            System.out.println(pair.getKey()  + " | " + pair.getValue());
//            System.out.println(pair.getValue().getMonth());
            if(pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() < 8){
                iterator.remove();

            }else{
                continue;
            }

        }

//        System.out.println(map.size());

    }

    public static void main(String[] args) {
//        removeAllSummerPeople(createMap());
    }
}


//package com.javarush.task.task08.task0816;
//
//        import java.util.*;
//
///*
//Добрая Зинаида и летние каникулы
//*/
//
//public class Solution {
//    public static HashMap<String, Date> createMap() {
//        HashMap<String, Date> map = new HashMap<String, Date>();
//        map.put("Stallone", new Date("JUNE 1 2010"));
//        map.put("Stallone1", new Date("MARCH 2 1980"));
//        map.put("Stallone2", new Date("MAY 6 1180"));
////        map.put("Stallone3", new Date("OCTOBER 1 1910"));
////        map.put("Stallone4", new Date("JANUARY 1 91980"));
////        map.put("Stallone5", new Date("AUGUST 1 1980"));
////        map.put("Stallone6", new Date("APRIL 30 1980"));
////        map.put("Stallone7", new Date("FEBRUARY 1 1981"));
////        map.put("Stallone8", new Date("JULY 4 191"));
////        map.put("Stallone9", new Date("SEPTEMBER 17 2000"));
//
//        return  map;
//
//    }
//
//    public static void removeAllSummerPeople(HashMap<String, Date> map) {
//        //напишите тут ваш код
//
//
//
//        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
//
//        while(iterator.hasNext()) {
//
//            Map.Entry<String, Date> pair = iterator.next();
//            System.out.print(pair.getKey() + " | " + pair.getValue());
//            System.out.print(pair.getValue().getMonth());
//            System.out.print(pair.getValue().getMonth() > 5 && pair.getValue().getMonth() < 8);
//            System.out.println();
//        }
//
//
//
//
//    }
//
//
//}
//
//    public static void main(String[] args) {
//        HashMap<String, Date> map = new HashMap<String, Date>();
//        map = createMap();
//
//        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
//
//        while(iterator.hasNext()) {
//
//            Map.Entry<String, Date> pair = iterator.next();
//            System.out.print(pair.getKey() + " | " + pair.getValue());
//            System.out.print(pair.getValue().getMonth());
//            System.out.print(pair.getValue().getMonth() > 5 && pair.getValue().getMonth() < 8);
//            System.out.println();
//        }
//
//        System.out.println("_____________________________");
//
//        removeAllSummerPeople(map);
//    }
//}
//
////if(pair.getValue().getMonth() > 5 && pair.getValue().getMonth() < 8){
////
//////               iterator.remove();