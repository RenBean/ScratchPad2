package main.java.week2.day2;

/**
 * Created by Ari on 7/19/16.
 */
public class Day2DoWhileLoop {
    public static void main(String args[]) {
        // call the whileLoop method
        whileLoop(5);
        System.out.println();
        //call the doWhileLoopMethod
        doWhileLoop(5);
    }

    // create a new method called 'whileLoop' that takes an int called 'start'
    public static void whileLoop (int start){
        // create a while loop that iterates from start to zero and prints out the result
        while (start >= 0 ) {
            System.out.println(start);
            start--;
        }
    }


    // create a new method called 'doWhileLoop' that takes an int called 'start'
    public static void doWhileLoop (int start){
        // create a do-while loop that iterates from start to zero and prints out the result
        do {
            System.out.println(start);
            start--;
        } while(start >= 0);{

        }
    }


}
