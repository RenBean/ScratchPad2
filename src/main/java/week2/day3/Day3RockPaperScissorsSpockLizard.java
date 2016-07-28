package main.java.week2.day3;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Ari on 7/20/16.
 */
public class Day3RockPaperScissorsSpockLizard {

    private String player1Choice;
    private String player2Choice;


    public static void main(String[] args) {


        Day3RockPaperScissorsSpockLizard rpsSL = new Day3RockPaperScissorsSpockLizard();
        rpsSL.setPlayerChoices();
        rpsSL.decideWinner();
    }

    private void setPlayerChoices() {
        Scanner scanner = new Scanner(System.in);

        player1Choice = "";
        while (!(player1Choice.equalsIgnoreCase("rock") || player1Choice.equalsIgnoreCase("paper") || player1Choice.equalsIgnoreCase("scissors")|| player1Choice.equalsIgnoreCase("spock")|| player1Choice.equalsIgnoreCase("lizard"))) {
            System.out.println("Lets play a game...\nMake your selection \"Rock\" \"Paper\" \"Scissors\" \"Spock\" \"Lizard\"?");
            player1Choice = scanner.nextLine();

            if (player1Choice.equalsIgnoreCase("rock")) {
                System.out.println("You have selected the Rock");
            } else if (player1Choice.equalsIgnoreCase("paper")) {
                System.out.println("You have selected the Paper");
            } else if (player1Choice.equalsIgnoreCase("scissors")) {
                System.out.println("You have selected the Scissors");
            } else if (player1Choice.equalsIgnoreCase("spock")) {
                System.out.println("You have selected the Spock");
            } else if (player1Choice.equalsIgnoreCase("lizard")) {
                System.out.println("You have selected the Lizard");
            } else {
                System.out.println("Invalid selection");
            }
        }
        player2Choice = randomSelection();

    }

    private void decideWinner() {

        if (player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("scissors")) {
            System.out.println("Player Wins!!!\n\"Rock\" breaks \"Scissors\"!!");
        } else if (player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("lizard")) {
            System.out.println("Player Wins!!!\n\"Rock\" crushes \"Lizard\"!!");
        }else if (player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("paper")) {
            System.out.println("Computer Wins!!!\n\"Paper\" covers \"Rock\"!!");

        } else if (player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("paper")) {
            System.out.println("Player Wins!!!\n\"Scissors\" cut \"Paper\"!!");
        } else if (player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("lizard")) {
            System.out.println("Player Wins!!!\n\"Scissors\" decapitate \"Lizard\"!!");


        } else if (player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("rock")) {
            System.out.println("Player Wins!!!\n\"Paper\" covers \"Rock\"!!");
        } else if (player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("spock")) {
            System.out.println("Player Wins!!!\n\"Paper\" disproves \"Spock\"!!");
        } else if (player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("lizard")) {
            System.out.println("Computer Wins!!!\n\"Lizard\" eats \"Paper\"!!");

        } else if (player1Choice.equalsIgnoreCase("spock") && player2Choice.equalsIgnoreCase("rock")) {
            System.out.println("Player Wins!!!\n\"Spock\" vaporizes \"Rock\"!!");
        } else if (player1Choice.equalsIgnoreCase("spock") && player2Choice.equalsIgnoreCase("scissors")) {
            System.out.println("Player Wins!!!\n\"Spock\" smashes \"scissors\"!!");
        }else if (player1Choice.equalsIgnoreCase("spock") && player2Choice.equalsIgnoreCase("lizard")) {
            System.out.println("Computer Wins!!!\n\"Lizard\" poisons \"Spock\"!!");



        } else if (player2Choice.equalsIgnoreCase("rock") && player1Choice.equalsIgnoreCase("scissors")) {
            System.out.println("Computer Wins!!!\n\"Rock\" breaks \"Scissors\"!!");
        } else if (player2Choice.equalsIgnoreCase("rock") && player1Choice.equalsIgnoreCase("lizard")) {
            System.out.println("Computer Wins!!!\n\"Rock\" crushes \"Lizard\"!!");
        } else if (player2Choice.equalsIgnoreCase("rock") && player1Choice.equalsIgnoreCase("paper")) {
            System.out.println("Player Wins!!!\n\"Paper\" covers \"Rock\"!!");

        } else if (player2Choice.equalsIgnoreCase("scissors") && player1Choice.equalsIgnoreCase("paper")) {
            System.out.println("Computer Wins!!!\n\"Scissors\" cut \"Paper\"!!");
        } else if (player2Choice.equalsIgnoreCase("scissors") && player1Choice.equalsIgnoreCase("lizard")) {
            System.out.println("Computer Wins!!!\n\"Scissors\" decapitate \"Lizard\"!!");

        } else if (player2Choice.equalsIgnoreCase("paper") && player1Choice.equalsIgnoreCase("rock")) {
            System.out.println("Computer Wins!!!\n\"Paper\" covers \"Rock\"!!");
        } else if (player2Choice.equalsIgnoreCase("paper") && player1Choice.equalsIgnoreCase("spock")) {
            System.out.println("Computer Wins!!!\n\"Paper\" disproves \"Spock\"!!");
        } else if (player2Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("lizard")) {
                System.out.println("Player Wins!!!\n\"Lizard\" eats \"Paper\"!!");

        } else if (player2Choice.equalsIgnoreCase("spock") && player1Choice.equalsIgnoreCase("rock")) {
            System.out.println("Computer Wins!!!\n\"Spock\" vaporizes \"Rock\"!!");
        } else if (player2Choice.equalsIgnoreCase("spock") && player1Choice.equalsIgnoreCase("scissors")) {
                System.out.println("Computer Wins!!!\n\"Spock\" smashes \"scissors\"!!");
        } else if (player2Choice.equalsIgnoreCase("spock") && player1Choice.equalsIgnoreCase("lizard")) {
                System.out.println("Player Wins!!!\n\"Lizard\" poisons \"Spock\"!!");

        } else {
            System.out.println("It's a tie!");
        }


    }

    public static String randomSelection() {
        int min = 1;
        int max = 5;
        String randomSelection;
        Random random = new Random(System.currentTimeMillis());
        int randomNumber = random.nextInt((max - min) + 1) + min;
        if (randomNumber == 1) {
            randomSelection = "rock";
            System.out.println("Computer has selected Rock");
        } else if (randomNumber == 2) {
            randomSelection = "paper";
            System.out.println("Computer has selected Paper");
        } else if (randomNumber == 3) {
            randomSelection = "scissors";
            System.out.println("Computer has selected Scissors");
        } else if (randomNumber == 4) {
            randomSelection = "spock";
            System.out.println("Computer has selected Spock");
        } else {
            randomSelection = "lizard";
            System.out.println("Computer has selected Lizard");

        }
        return randomSelection;
    }
}


