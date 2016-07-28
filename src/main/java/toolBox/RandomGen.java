package main.java.toolBox;

import java.util.Random;

/**
 * Created by Ari on 7/20/16.
 */
public class RandomGen {


        String player2Choice;
        //player2Choice = randomSelection();

    public static String randomSelection() {
        int min = 1;
        int max = 3;
        String randomSelection;
        Random random = new Random(System.currentTimeMillis());
        int randomNumber = random.nextInt((max - min) + 1) + min;
        if (randomNumber == 1) {
            randomSelection = "rock";
            System.out.println("Computer has selected Rock");
        } else if (randomNumber == 2) {
            randomSelection = "paper";
            System.out.println("Computer has selected Paper");
        } else {
            randomSelection = "scissors";
            System.out.println("Computer has selected Scissors");
        }
        return randomSelection;
    }
}

