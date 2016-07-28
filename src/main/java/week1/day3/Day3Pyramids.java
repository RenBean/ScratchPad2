package main.java.week1.day3;

/**
 * Created by Ari on 7/13/16.
 */
public class Day3Pyramids {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println(" ");
        }
    }
}


