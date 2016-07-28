package main.java.toolBox;
import java.util.Random;


public class RandomGenerator {


    public static int randomInt(int min, int max) {


        Random random = new Random(System.currentTimeMillis());
        // we just made Random more randowm with System.currentTimeMillis
        int randomNumber = random.nextInt((max - min) + 1) + min;

        return randomNumber;
    }

    public static void main(String[] args) {

        System.out.println(randomInt(5, 12));


    }

    public static int randomInt2(int min, int max) {


        Random random = new Random(System.currentTimeMillis());
        // we just made Random more randowm with System.currentTimeMillis
        int randomNumber = random.nextInt((max + min) - 1) + min;

        return randomNumber;
    }
}