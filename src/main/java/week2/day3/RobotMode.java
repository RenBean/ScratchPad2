package main.java.week2.day3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Ari on 7/20/16.
 */
public class RobotMode {
    private String player1Choice;
    private String player2Choice;

    int unicornWinsCount = 0;
    int vulcanWinsCount = 0;
    int tieWinsCount = 0;

    private ArrayList<String> tools = new ArrayList<>();



    public static void main(String[] args) {

        RobotMode robotMode = new RobotMode();
        int autoPlayCounter = 0 ;
        int turns = 1000;

        while (turns > autoPlayCounter) {
            autoPlayCounter++;
            robotMode.setPlayerChoices();
            robotMode.decideWinner();
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------------------  STATS  --------------------------");
        System.out.println("--------------------------------------------------------------");
        robotMode.printStats();


    }

    private void setPlayerChoices() {
        Scanner scanner = new Scanner(System.in);

        player2Choice = randomSelection2();
        player1Choice = randomSelection1();
    }

    private void decideWinner() {

            if (player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("scissors")) {
                System.out.println("Unicorn Wins!!!\n\"Rock\" beats \"Scissors\"");
                unicornWinsCount++;
            } else if (player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("paper")) {
                System.out.println("Unicorn Wins!!!\n\"Scissors\" beats \"Paper\"");
                unicornWinsCount++;
            } else if (player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("rock")) {
                System.out.println("Unicorn Wins!!!\n\"Paper\" beats \"Rock\"");
                unicornWinsCount++;

            } else if (player2Choice.equalsIgnoreCase("rock") && player1Choice.equalsIgnoreCase("scissors")) {
                System.out.println("Vulcan Wins!!!\n\"Rock\" beats \"Scissors\"");
                vulcanWinsCount++;
            } else if (player2Choice.equalsIgnoreCase("scissors") && player1Choice.equalsIgnoreCase("paper")) {
                System.out.println("Vulcan Wins!!!\n\"Scissors\" beats \"Paper\"");
                vulcanWinsCount++;
            } else if (player2Choice.equalsIgnoreCase("paper") && player1Choice.equalsIgnoreCase("rock")) {
                System.out.println("Vulcan Wins!!!\n\"Paper\" beats \"Rock");
                vulcanWinsCount++;
            } else {
                System.out.println("It's a tie!");
                tieWinsCount++;
            }
    }

    private void printStats(){

        int rockCounter = 0;
        int paperCounter = 0;
        int scissorsCounter = 0;
        for (String tool: tools){
            switch (tool){
                case "rock" : rockCounter++; break;
                case "paper" : paperCounter++; break;
                case "scissors" : scissorsCounter++; break;
            }
        }
        System.out.println("Rock wins: "+ rockCounter);
        System.out.println("Paper wins: "+ paperCounter);
        System.out.println("Scissors wins: "+ scissorsCounter);

        System.out.println("Tie Win count: "+tieWinsCount);
        System.out.println("Unicorn Win count: "+unicornWinsCount);
        System.out.println("Vulcan Win count: "+vulcanWinsCount);

    }

    public String randomSelection1() {
        int min = 1;
        int max = 3;
        String randomSelection1;
        Random random = new Random(System.nanoTime());
        int randomNumber = random.nextInt((max - min) + 1) + min;
        if (randomNumber == 1) {
            randomSelection1 = "rock";
            System.out.println("Unicorn has selected Rock");

        } else if (randomNumber == 2) {
            randomSelection1 = "paper";
            System.out.println("Unicorn has selected Paper");

        } else {
            randomSelection1 = "scissors";
            System.out.println("Unicorn has selected Scissors");

        }
        return randomSelection1;
    }

    public String randomSelection2() {
        int min = 1;
        int max = 3;
        String randomSelection2;
        Random random = new Random(System.currentTimeMillis());
        int randomNumber = random.nextInt((max - min) +1) +min;
        if(randomNumber == 1) {
            randomSelection2 = "rock";
            System.out.println("Vulcan has selected Rock");

        } else if (randomNumber == 2) {
            randomSelection2 = "paper";
            System.out.println("Vulcan has selected Paper");

        } else {
            randomSelection2 = "scissors";
            System.out.println("Vulcan has selected Scissors");

        }
        tools.add(randomSelection2);
        return randomSelection2;
    }

}
