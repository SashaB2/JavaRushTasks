package com.javarush.task.task21.task2110;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* 
Рефакторинг методов
*/
public class Solution implements AutoCloseable{

    public static void writeZipEntriesToFile(String zipFileName, String outputFileName) {
//        Charset charset = StandardCharsets.UTF_8;
//        Path outputFilePath = Paths.get(outputFileName);

//
//        try (ZipFile zipFile = new ZipFile(zipFileName);
////                BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFileName), StandardCharsets.UTF_8)){
///             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName), StandardCharsets.UTF_8))){
////        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName), StandardCharsets.UTF_8))){
////            try(ZipFile zipFile = new ZipFile(zipFileName)) {
//                String newLine = System.getProperty("line.separator");
//                for(Enumeration entries = zipFile.entries(); entries.hasMoreElements(); ) {
//                    String zipEntryName = ((ZipEntry) entries.nextElement()).getName() + newLine;
//                    writer.write(zipEntryName, 0, zipEntryName.length());
//                }
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Charset charset = StandardCharsets.UTF_8;
        Path outputFilePath = Paths.get(outputFileName);

        try (        BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset);
                     ZipFile zip = new ZipFile(zipFileName)){
            String newLine = System.getProperty("line.separator");
            for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
                String zipEntryName = ((ZipEntry) entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void close()throws Exception {
    }

        public static void main(String[] args) {

    }


}