package main.java.week1.day3;

/**
 * Created by Ari on 7/13/16.
 */
public class Day3GreatestCommonDenominator {

    private static long tmpA = 2500;
    private static long tmpB = 500;

    public static void main(String[] args) {
        long result = gcd(tmpA, tmpB);
        System.out.println("RESULT: " + result);
    }


    public static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
}

