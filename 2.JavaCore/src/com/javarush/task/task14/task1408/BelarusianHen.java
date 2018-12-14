package com.javarush.task.task14.task1408;

class BelarusianHen extends Hen{

    public int getCountOfEggsPerMonth(){
        return 8;
    }
    public String getDescription(){
        return "Я - курица." + " Моя страна - "+Country.BELARUS+". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";

    }
}
