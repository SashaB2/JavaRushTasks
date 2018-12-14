package com.javarush.task.task13.task1319;

import java.io.*;

/*
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        File file = new File(reader.readLine());

//        if(file.createNewFile()){
//            System.out.println("Created");
//        }else{
//            System.out.println("Not created");
//        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        String str;

        while(true){

            str = reader.readLine();
            writer.write(str);
            writer.newLine();
            writer.flush();
            System.out.println(str);
            if(str.equals("exit")){
                break;
            }
        }
        writer.close();
        reader.close();



    }
}
