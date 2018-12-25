package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hippodrome{

    private List<Horse> horses = new ArrayList<>();

    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses( ) {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for(Horse horse : horses){
            horse.move();
        }
    }

    public void print(){
        for(Horse horse : horses){
            horse.print();
        }

        for(int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse temp = null;
        for(Horse horse : horses
            ) {
            if(temp == null){
                temp = horse;
                continue;
            }
            if(temp.getDistance() < horse.getDistance()){
                temp = horse;
            }
        }

        return temp;
    }
    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());
    }


    public static void main(String[] args) throws InterruptedException {

        List<Horse> hor = new ArrayList<Horse>();
        hor.add(new Horse("One",3.0, 0.0));
        hor.add(new Horse("Two",3.0, 0.0));
        hor.add(new Horse("Three",3.0, 0.0));
        game = new Hippodrome(hor);

        game = new Hippodrome(hor);
        game.run();
        game.printWinner();
    }
}
