package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

import static com.javarush.task.task18.task1826.test.a;

public class Solution {

    private static CommandTypes commandType;

    private static String fileInputName;

    private static String fileOutputName;

    public static void main(String[] args) {



//        commandParser(args[0], args[1], args[2]);
        commandParser("-e", "C:\\Users\\B2\\Desktop\\second.txt", "C:\\Users\\B2\\Desktop\\first.txt");
        if(commandType.equals(CommandTypes.CodeFile)){
            codeFile();
        }else if(commandType.equals(CommandTypes.DecodeFile)){
            codeFile();
        }

    }

    private static void commandParser(String commandTypp, String fileInputNamee, String fileOutputNamee){


        commandType = commandTypp.equals("-e")?CommandTypes.CodeFile:CommandTypes.DecodeFile;
        fileInputName = fileInputNamee;
        fileOutputName = fileOutputNamee;
    }

    private static void codeFile (){
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileInputName));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileOutputName));

            while(bufferedInputStream.available()>0){
                int countCodeByte = CodeAndDecodeFile(bufferedInputStream.read());
//                System.out.println(countCodeByte);
                bufferedOutputStream.write(countCodeByte);
            }

            bufferedInputStream.close();
            bufferedOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private final static int CodeAndDecodeFile(int inputNumberByte){
        return inputNumberByte^(int)'g';
    }



    private enum CommandTypes{
        CodeFile,
        DecodeFile
    }
}
