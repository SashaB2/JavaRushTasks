package com.javarush.task.task19.task1905;

public class Test {
    public static void main(String[] args) {

        String beforeAdjustString = "+38(050)123-45-67";
        String plusParth = "\\+";
        String numberParth = "[0-9]+";
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < beforeAdjustString.length(); i++) {
            if(Character.toString(beforeAdjustString.charAt(i)).matches(plusParth) || Character.toString(beforeAdjustString.charAt(i)).matches(numberParth)){
                temp.append(beforeAdjustString.charAt(i));
            }
        }

        System.out.println(temp);

        System.out.println("Ivanov, Ivan".split(" ")[1]);
        System.out.println("Ivanov, Ivan".split(" ")[0].substring(0, "Ivanov, Ivan".split(" ")[0].length()));
    }
}
