package week2.day1;

/**
 * Created by Ari on 7/18/16.
 */
public class Day1FizzBuzz {

    public static void main(String[] args) {
//        thatWay();
//        thisWay();
        theOtherWay();
    }

//    public static void thisWay() {
//        // count from 1 to 100 (loop?)
//        String returnThis = "";
//        for (int count = 1; count < 100; count++) {
//            returnThis = "";
//            // check if divisible by 3 -- print Fizz
//            if (count % 3 == 0) {
//                returnThis += "Fizz";
//
//                // check if divisible by 5 -- print Buzz
//            }
//            if (count % 5 == 0) {
//                returnThis += "Buzz";
//                //    System.out.println("Buzz");
//                // if we have a word, print it, else print the number
//                //} if ((count % 3 == 0) && (count % 5 == 0)) {
//                //   if (count % 15 == 0) {
//                //  returnThis = "FizzBuzz";
//                //    System.out.println(count);
//            }
//            if (returnThis.isEmpty()) {
//                System.out.println(count);
//            } else {
//                System.out.println(returnThis);
//            }
//        }
//
//    }
//
//
//    public static void thatWay() {
//
//        for (int count = 1; count <= 100; count++) {
//
//
//            if (count % 15 == 0) {
//                System.out.println("FizzBuzz");
//            } else if (count % 5 == 0) {
//                System.out.println("Buzz");
//            } else if (count % 3 == 0) {
//                System.out.println("Fizz");
//            } else {
//                System.out.println(count);
//            }
//
//        }
//
//
//    }
//

    public static void theOtherWay() {
        for (int count = 1; count <= 100; count++){

            if (count % 3 == 0) {
                System.out.print("Fizz");
            }
            if (count % 5 == 0) {
                System.out.print("Buzz");
            }
            if (count % 3 != 0 && count % 5 != 0) {
                System.out.print("" + count);
            }

            System.out.println();

        }
    }


}






