package week2.day1;

/**
 * Created by Ari on 7/18/16.
 */
//if they type in the word [exit]...
//listens for exit
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day1Palindrome {

    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Enter a word to test. Use 'exit' to stop application");
        while(true) {
            try {
                String inputString = bufferedReader.readLine();

                if(inputString.equalsIgnoreCase("exit")){
                    break;
                }
                System.out.println(isPalindromeStringBuilder(inputString));
                //System.out.println(isPalindromeArrayLoop(inputString));
//                if(isPalindromeArrayLoop(inputString)){
//                    System.out.println("True");
//                } else {
//                    System.out.println("False");
//                }


            } catch (Exception myExceptions) {
                myExceptions.printStackTrace();
            }
        }
    }

    private static boolean isPalindromeArrayLoop(String inputString) {
        boolean isPalindrome = false;
        //reverse inputString using an array loop and see if there is a match
        char[] inputStringCopy = inputString.toCharArray();
        int i = 0;
        for (int j = inputStringCopy.length-1; j >= 0; j--) {
            inputStringCopy[i] = inputString.charAt(j);
            i++;
        }
        if(inputString.equalsIgnoreCase(new String(inputStringCopy))){
            isPalindrome = true;
        }

        return isPalindrome;
    }

    private static boolean isPalindromeStringBuilder(String inputString) {
        boolean isPalindrome = false;
        //reverse inputString using StringBuilder and see if it matches itself

        StringBuilder inputStringCopy = new StringBuilder();
        inputStringCopy.append(inputString);
        inputStringCopy = inputStringCopy.reverse();
        if(inputString.equalsIgnoreCase(inputStringCopy.toString())){
            isPalindrome = true;

        }

        return isPalindrome;
    }
}

