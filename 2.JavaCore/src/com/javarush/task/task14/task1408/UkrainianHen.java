package com.javarush.task.task14.task1408;

class UkrainianHen extends Hen{

    String Sssss = "Ukraine";

    public int getCountOfEggsPerMonth(){
        return 6;
    }
    public String getDescription(){
        return "Я - курица." + " Моя страна - "+ Country.UKRAINE +". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
