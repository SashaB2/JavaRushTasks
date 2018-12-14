package com.javarush.task.task14.task1408;

class RussianHen extends Hen{



    public int getCountOfEggsPerMonth(){
        return 5;
    }
    public String getDescription(){
        return "Я - курица." + " Моя страна - "+ Country.RUSSIA +". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
