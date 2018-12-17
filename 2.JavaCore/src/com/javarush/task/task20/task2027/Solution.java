package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words = detectAllWords(crossword, "home", "same");


        for(Word word: words) {
            System.out.println(word.toString());
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> listWords = new ArrayList<>();

        for(String word: words) {
            char [] arrWord = word.toCharArray();
            //-----------------------------------------------------------------
            for(int y = 0; y < crossword.length; y++) {
                for(int x = 0; x < crossword[y].length; x++) {
                    if((crossword[y][x] == arrWord[0])){
                        Word tempWord = null;
                        int count = 0;
                        int startX = x;
                        int startY = y;

                        //diagonal right up
                        //-----------------------------------------------------------------------------------------------
                        int yyyyyyy = y;
                        int xxxxxxx = x;
                         //(yyyy + (word.length()-1) < crossword.length) && ((xxxx + (word.length()-1) < crossword[y].length))
                        if((yyyyyyy - (word.length()-1) >= 0) && ((xxxxxxx + (word.length()-1) < crossword[y].length))){
                            for(int letterNumber = 0; letterNumber < arrWord.length; letterNumber++) {
                                if(arrWord[letterNumber] == crossword[yyyyyyy][xxxxxxx]){
                                    yyyyyyy--;
                                    xxxxxxx++;
                                    ++count;
                                    if(count == arrWord.length){
                                        tempWord = new Word(word);
                                        tempWord.startX = startX;
                                        tempWord.startY = startY;
                                        tempWord.endX = xxxxxxx-1;
                                        tempWord.endY = yyyyyyy+1;
                                        count = 0;
                                    }
                                } else {
                                    count = 0;
                                    break;
                                }
                            }
                        }

                        //diagonal left up
                        //-----------------------------------------------------------------------------------------------
                        int yyyyyy = y;
                        int xxxxxx = x;
                        if((yyyyyy - (word.length()-1) >= 0) && ((xxxxxx - (word.length()-1) >= 0))){
                            for(int letterNumber = 0; letterNumber < arrWord.length; letterNumber++) {
                                if(arrWord[letterNumber] == crossword[yyyyyy][xxxxxx]){
                                    yyyyyy--;
                                    xxxxxx--;
                                    ++count;
                                    if(count == arrWord.length){
                                        tempWord = new Word(word);
                                        tempWord.startX = startX;
                                        tempWord.startY = startY;
                                        tempWord.endX = xxxxxx+1;
                                        tempWord.endY = yyyyyy+1;
                                        count = 0;
                                    }
                                } else {
                                    count = 0;
                                    break;
                                }
                            }
                        }

                        //diagonal left down
                        //-----------------------------------------------------------------------------------------------
                        int yyyyy = y;
                        int xxxxx = x;
                        if((yyyyy + (word.length()-1) < crossword.length) && ((xxxxx - (word.length()-1) >= 0))){
                            for(int letterNumber = 0; letterNumber < arrWord.length; letterNumber++) {
                                if(arrWord[letterNumber] == crossword[yyyyy][xxxxx]){
                                    yyyyy++;
                                    xxxxx--;
                                    ++count;
                                    if(count == arrWord.length){
                                        tempWord = new Word(word);
                                        tempWord.startX = startX;
                                        tempWord.startY = startY;
                                        tempWord.endX = xxxxx+1;
                                        tempWord.endY = yyyyy-1;
                                        count = 0;
                                    }
                                } else {
                                    count = 0;
                                    break;
                                }
                            }
                        }

                        //diagonal right down
                        //-----------------------------------------------------------------------------------------------
                        int yyyy = y;
                        int xxxx = x;
                        if((yyyy + (word.length()-1) < crossword.length) && ((xxxx + (word.length()-1) < crossword[y].length))){
                            for(int letterNumber = 0; letterNumber < arrWord.length; letterNumber++) {
                                if(arrWord[letterNumber] == crossword[yyyy][xxxx]){
                                    yyyy++;
                                    xxxx++;
                                    ++count;
                                    if(count == arrWord.length){
                                        tempWord = new Word(word);
                                        tempWord.startX = startX;
                                        tempWord.startY = startY;
                                        tempWord.endX = xxxx-1;
                                        tempWord.endY = yyyy-1;
                                        count = 0;
                                    }
                                } else {
                                    count = 0;
                                    break;
                                }
                            }
                        }

                        //vertical up
                        int yyy = y;
                        if(yyy - (word.length()-1) >= 0){
                            for(int letterNumber = 0; letterNumber < arrWord.length; letterNumber++) {
                                if(arrWord[letterNumber] == crossword[yyy][x]){
                                    ++count;
                                    yyy--;
                                    if(count == arrWord.length){
                                        tempWord = new Word(word);
                                        tempWord.startX = startX;
                                        tempWord.startY = startY;
                                        tempWord.endX = x;
                                        tempWord.endY = yyy+1;
                                        count = 0;
                                    }
                                } else {
                                    count = 0;
                                    break;
                                }
                            }
                        }

                        //vertical down
                        int yy = y;
                        if(yy + word.length()-1 < crossword.length){
                            for(int letterNumber = 0; letterNumber < arrWord.length; letterNumber++) {
                                if(arrWord[letterNumber] == crossword[yy][x]){
                                    ++count;
                                    yy++;
                                    if(count == arrWord.length){
                                        tempWord = new Word(word);
                                        tempWord.startX = startX;
                                        tempWord.startY = startY;
                                        tempWord.endX = x;
                                        tempWord.endY = yy-1;
                                        count = 0;
                                    }
                                } else {
                                    count = 0;
                                    break;
                                }
                            }
                        }

                        //Horisontal left
                        //----------------------------------------------------
                        int xxx = x;
                        if(!(word.length() - 1 > xxx)){
                            for(int letterNumber = 0; letterNumber < arrWord.length; letterNumber++) {
                                if(arrWord[letterNumber] == crossword[y][xxx]){
                                    xxx--;
                                    ++count;
                                    if(count == arrWord.length){
                                        tempWord = new Word(word);
                                        tempWord.startX = startX;
                                        tempWord.startY = startY;
                                        tempWord.endX = xxx + 1;
                                        tempWord.endY = y;
                                        count = 0;
                                    }
                                } else {
                                    count = 0;
                                    break;
                                }
                            }
                        }

                        //Horizontal right
                        //----------------------------------------------------
                        int xx = x;
                        if(!((crossword[y].length) - word.length() < xx)){
                            for(int letterNumber = 0; letterNumber < arrWord.length; letterNumber++) {
                                if(arrWord[letterNumber] == crossword[y][xx]){
                                    ++count;
                                    xx++;
                                    if(count == arrWord.length){
                                        tempWord = new Word(word);
                                        tempWord.startX = startX;
                                        tempWord.startY = startY;
                                        tempWord.endX = xx - 1;
                                        tempWord.endY = y;
                                        count = 0;
                                    }
                                } else {
                                    count = 0;
                                    break;
                                }

                            }
                        }
                        //------------------------------------------------------------
                        if(tempWord != null){
                            listWords.add(tempWord);
                            tempWord = null;
                        }
                    }
                }
            }

        }

        return listWords;
    }

    public static String convertArrToString(String [] arr){
        String temp = "";
        for(int i = 0; i < arr.length; i++) {
            temp += arr[i];
        }
        return temp;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}