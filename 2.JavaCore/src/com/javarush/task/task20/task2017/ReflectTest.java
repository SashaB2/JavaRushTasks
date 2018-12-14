package com.javarush.task.task20.task2017;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    private int number;
    private String name= "default";

    public ReflectTest(){}

    public ReflectTest(int number, String name){
        this.number = number;
        this.name = name;
    }

    public int gtNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    private void setName(String name){
        this.name = name;
    }

    private void printData(){
        System.out.println(number + name);
    }

    public static void main(String[] args) {
        ReflectTest reflectTest = new ReflectTest();
        int number = reflectTest.gtNumber();
        String name = null;
        System.out.println(number+name);
        //set field infomation
        try{
            Field fieldName = reflectTest.getClass().getDeclaredField("name");
            fieldName.setAccessible(true);
            name = (String) fieldName.get(reflectTest);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(number+name);

        //run method
        try{
            Method method = reflectTest.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(reflectTest);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //set field name
        try {
            Field field = reflectTest.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(reflectTest, (String) "New value");
            name = (String) field.get(reflectTest);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        reflectTest.printData();

        //create instance of class without params
        ReflectTest reflectTest1;
        try{
            Class clasz = Class.forName(ReflectTest.class.getName());
            reflectTest1 = (ReflectTest) clasz.newInstance();
            reflectTest1.printData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        //create instance of class with params
        ReflectTest reflectTest2;
        try {
            Class clazz = Class.forName(ReflectTest.class.getName());
            Class[] params = {int.class, String.class};
            reflectTest2 = (ReflectTest) clazz.getConstructor(params).newInstance(1, "q");
            reflectTest2.printData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------");

        try{
            ReflectTest reflectTest3;
            Class clazz = Class.forName(ReflectTest.class.getName());
            Constructor [] constructors = clazz.getDeclaredConstructors();
            for(Constructor constructor: constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                for(Class paramType : paramTypes) {
                    System.out.println(paramType.getName());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
