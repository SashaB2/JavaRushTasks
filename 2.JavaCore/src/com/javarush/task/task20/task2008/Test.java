package com.javarush.task.task20.task2008;

import java.io.*;

public class Test {
    public static class Singelton implements Serializable{
        private static Singelton singelton;

        private Singelton(){}

        public static Singelton getSingelton(){
            if(singelton == null){
                singelton = new Singelton();
            }
            return singelton;
        }
    }

    public static void main(String[] args) throws IOException {
        Singelton singelton = Singelton.getSingelton();

        ByteArrayOutputStream byteArrayOutputStream = serSinginstance(singelton);

        FileOutputStream fileInputStream = new FileOutputStream("file");
        PrintStream printStream = new PrintStream(fileInputStream, false, "UTF-8");
        printStream.write(byteArrayOutputStream.toByteArray());
    }

    public static ByteArrayOutputStream serSinginstance(Singelton singelton) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(singelton);

        return byteArrayOutputStream;
    }

    public static Singelton dessingInstace(ByteArrayOutputStream byteArrayOutputStream) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Singelton singelton = (Singelton) objectInputStream.readObject();

        return singelton;
    }
}
