package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        public SubSolution() throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            throw new NotSerializableException();
        }

        private void writeObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
