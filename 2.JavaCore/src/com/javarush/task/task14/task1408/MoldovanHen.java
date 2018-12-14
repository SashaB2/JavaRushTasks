package com.javarush.task.task14.task1408;

class MoldovanHen extends Hen{


    public int getCountOfEggsPerMonth(){
        return 7;
    }
    public String getDescription(){
        return "Я - курица." + " Моя страна - "+ Country.MOLDOVA +". Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";

    }
}
