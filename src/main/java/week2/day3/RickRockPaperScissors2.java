package week2.day3;

        import java.util.ArrayList;
        import java.util.Random;

public class RickRockPaperScissors2 {

    private String player1Choice;
    private String player2Choice;
    private ArrayList<String> wins = new ArrayList<>();
    private ArrayList<String> tools = new ArrayList<>();

    public static void main(String[] args) {

        RickRockPaperScissors2 rps = new RickRockPaperScissors2();
        for(int i = 0; i < 1000; i++) {
            rps.setPlayers();
            rps.decideWinner();
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("---------------------------  STATS  --------------------------");
        System.out.println("--------------------------------------------------------------");
        rps.printStats();
    }

    private void setPlayers() {
        player1Choice = randomSelection();
        player2Choice = randomSelection();
    }

    private void decideWinner() {

        String winnerAnnouncement;
        String winner;
        if(player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("scissors")) {
            winnerAnnouncement = "Player: ROCK vs Computer: SCISSORS ----- PLAYER WINS";
            winner = "player";
        } else if(player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("rock")) {
            winnerAnnouncement = "Player: SCISSORS vs Computer: ROCK ----- COMPUTER WINS";
            winner = "computer";
        } else if(player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("rock")) {
            winnerAnnouncement = "Player: PAPER vs Computer: ROCK ----- PLAYER WINS";
            winner = "player";
        } else if(player1Choice.equalsIgnoreCase("rock") && player2Choice.equalsIgnoreCase("paper")) {
            winnerAnnouncement = "Player: ROCK vs Computer: PAPER ----- COMPUTER WINS";
            winner = "computer";
        } else if(player1Choice.equalsIgnoreCase("scissors") && player2Choice.equalsIgnoreCase("paper")) {
            winnerAnnouncement = "Player: SCISSORS vs Computer: PAPER ----- PLAYER WINS";
            winner = "player";
        } else if(player1Choice.equalsIgnoreCase("paper") && player2Choice.equalsIgnoreCase("scissors")) {
            winnerAnnouncement = "Player: PAPER vs Computer: SCISSORS ----- COMPUTER WINS";
            winner = "computer";
        } else {
            winnerAnnouncement = "Its a TIE ---- EVERYONE IS A LOSER";
            winner = "tie";
        }
        wins.add(winner);

        System.out.println(winnerAnnouncement);
    }

    private void printStats() {
        int player1WinsCount = 0;
        int player2WinsCount = 0;
        int tieWinsCount = 0;
        for(String winner: wins) {
            switch (winner) {
                case "player" : player1WinsCount++; break;
                case "computer" : player2WinsCount++; break;
                default : tieWinsCount++; break;
            }
        }
        System.out.println("Player 1 Wins: "+player1WinsCount);
        System.out.println("Player 2 Wins: "+player2WinsCount);
        System.out.println("Ties: "+tieWinsCount);
        int rockCount = 0;
        int paperCount = 0;
        int scissorsCount = 0;
        for(String tool : tools) {
            switch (tool) {
                case "rock" : rockCount++; break;
                case "paper" : paperCount++; break;
                case "scissors" : scissorsCount++; break;
            }
        }
        System.out.println("Rock Used: "+rockCount+" times");
        System.out.println("Paper Used: "+paperCount+" times");
        System.out.println("Scissors Used: "+scissorsCount+" times");
    }

    public String randomSelection() {
        int min = 1;
        int max = 3;
        String randomSelection;
        Random random = new Random();
//        Random random = new Random(System.currentTimeMillis());
        int randomNumber = random.nextInt((max - min) +1) +min;
        if(randomNumber == 1) {
            randomSelection = "rock";
        } else if (randomNumber == 2) {
            randomSelection = "paper";
        } else {
            randomSelection = "scissors";
        }
        tools.add(randomSelection);
        return randomSelection;
    }
}