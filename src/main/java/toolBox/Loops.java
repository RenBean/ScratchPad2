package main.java.toolBox;

public class Loops {

    //Covers 'while loops', 'for loops', and do-while loops'.

    int[] numbers = {10, 20, 30, 40, 50};
    //int[] bob = new int[4];
    //global method

    // while loops: Repeats a statement or group of statements while a given condition is true. It tests the condition
    // before executing the loop body.
    public void whileLoop() {
        int i = 0;
        //int bob = numbers[3]; length0
        //inside method within whileLoop
        while(i < numbers.length) {
            // is i less then the length of the array which is currently 5 (5)? (without more code it is an infinite loop)
            System.out.println("The number is: "+numbers[i]);
            //numbers is the array
            i--;
        }
        //adding IfThenElse is legal in this statement but not in a for statement
    }
//  void testMethod () {

//  }

    // for loops: Execute a sequence of statements multiple times and abbreviates the code that manages the loop variable.
    // int boolean counter incrementer
    public void forLoop() {
        for(int i = 0; i < numbers.length; i++) {
            //everything that is in the while loop; is in the for loop!
            System.out.println("The number is: "+numbers[i]);
            //the difference is this one always has to use primitives.
        }
    }

    public void enhancedForLoop() {
        for(int num : numbers) {
            System.out.println("The number is: "+num);
            //this takes the for loop and does exactly what it is doing but eliminates all of the primitives!
        }
    }


    //do-while loops: Like a while statement, except that it tests the condition at the end of the loop body
    public void doWileLoop() {
        int i = 0;
        do {
            System.out.println("The number is: "+ numbers[i]);
            i++;
        } while(i < numbers.length);
        //runs first then checks if variables are true
    }
}
