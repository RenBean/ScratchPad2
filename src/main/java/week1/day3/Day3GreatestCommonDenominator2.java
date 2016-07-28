package main.java.week1.day3;

public class Day3GreatestCommonDenominator2 {

    // long[] with values
    private static long[] longs = {500, 25000, 20, 100, 1000000, 800, 10};


    // main method
    public static void main(String [] args){
        long result = gcd(longs);
        System.out.println("The Greatest Common Denominator is " + result );
    }

    // gcd method
    private static long gcd(long[] input) {
        // loops through the long[]
        long result = input [0];
        for (int i = 0; i < input.length; i++) {
            // plugs values into the other gcd method
            result = Day3GreatestCommonDenominator.gcd(result, input[i]);
        }
        // returns the greatest common denominator
        return result;
    }
}
