//package com.javarush.task.task19.task1916;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Tet {
//    public static List<Solution.LineItem> lines = new ArrayList<Solution.LineItem>();
//
//    public static void main(String[] args) throws InterruptedException {
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String file1Name = null;
//        String file2Name = null;
//        List<String> firstFileData = new ArrayList<>();
//        List<String> secondFileData = new ArrayList<>();
//
//
////        try{
////            file1Name = bufferedReader.readLine();
//        file1Name = "C:\\Users\\B2\\Desktop\\1.txt";
////            file2Name = bufferedReader.readLine();
//        file2Name = "C:\\Users\\B2\\Desktop\\2.txt";
////        } catch (IOException e) {
////            e.printStackTrace();
////        }finally {
////            try {
////                bufferedReader.close();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
//
//        Solution.ReadFile readFile1 = new Solution.ReadFile(file1Name);
//        readFile1.start();
//        firstFileData = readFile1.getFileData();
//        readFile1.join();
//
//
//        Solution.ReadFile readFile2 = new Solution.ReadFile(file2Name);
//        readFile2.start();
//        secondFileData = readFile2.getFileData();
//        readFile2.join();
//
//        int siz = (firstFileData.size() > secondFileData.size()) ? firstFileData.size() : secondFileData.size();
//        int spCount = 0;
//        int tempI = 0;
//
//        while (tempI < siz) {
//            String temp2 = "";
//            String temp = "";
//            try {
//                temp = firstFileData.get(tempI);
//            } catch (IndexOutOfBoundsException e) {
//                temp = "";
//            }
//
//
//            try {
//                temp2 = secondFileData.get(spCount);
//            } catch (IndexOutOfBoundsException e) {
//                temp2 = "";
//            }
//
//
//            if(temp.equalsIgnoreCase(temp2)){
//                lines.add(new Solution.LineItem(Solution.Type.SAME, temp));
//                ++tempI;
//                ++spCount;
//            } else {
//                if(temp2.equals("") || (temp2.equals(firstFileData.get(tempI + 1)))){
//                    lines.add(new Solution.LineItem(Solution.Type.REMOVED, temp));
//                    ++tempI;
//                } else {
//                    lines.add(new Solution.LineItem(Solution.Type.ADDED, temp2));
//                    ++spCount;
//                }
//            }
//
//        }
//
//        for(Solution.LineItem a : lines){
//            System.out.println(a.line  + " -- " + a.type);
//        }
//
//
//    }
//
//
//    public static enum Type {
//        ADDED,        //добавлена новая строка
//        REMOVED,      //удалена строка
//        SAME          //без изменений
//    }
//
//    public static class LineItem {
//        public Solution.Type type;
//        public String line;
//
//        public LineItem(Solution.Type type, String line) {
//            this.type = type;
//            this.line = line;
//        }
//    }
//
//    static class ReadFile extends Thread{
//
//        private String fileName;
//        private ArrayList<String> fileData = new ArrayList<>();
//
//        public ReadFile(String fileName){
//            this.fileName = fileName;
//        }
//
//        public ArrayList<String> getFileData( ) {
//            return fileData;
//        }
//
//        @Override
//        public void run( ) {
//            try{
//                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));
//                while (bufferedReader.ready()){
//                    this.fileData.add(bufferedReader.readLine());
//                }
//                bufferedReader.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
