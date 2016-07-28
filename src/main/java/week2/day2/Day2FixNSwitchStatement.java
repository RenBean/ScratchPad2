package main.java.week2.day2;
import java.util.Scanner;


/**
 * Created by Ari on 7/19/16.
 */
public class Day2FixNSwitchStatement {
    public static Scanner scanner = new Scanner(System.in);
    private static char branch = 'C'; // C - CSE, E - ECE, M - Mech
    private static int year = 2;

    public static void main(String[] args) {
        switchIt();
    }
    public static void setYear (){
        System.out.println("Select your year 1-3 [1/2/3]");
        year = Day2FixNSwitchStatement.scanner.nextInt();
    }
    public static void setBranch1 (){
        System.out.println("Your branch is: ");
        year = Day2FixNSwitchStatement.scanner.nextInt();
    }
    public static void setBranch2 (){
        System.out.println("Select your branch [C/E/M]");
        year = Day2FixNSwitchStatement.scanner.nextInt();
    }
    public static void setBranch3 (){
        System.out.println("Select your branch [C/E/Z]");
        year = Day2FixNSwitchStatement.scanner.nextInt();
    }

    private static void switchIt() {
        switch (year) {
            case 1:
                System.out.println("English, Math, Drawing");
                break;
            case 2:
                switch (branch) // LINE C
                {
                    case 'C':
                        System.out.println("Date structures, Java, Computer Organization");
                        break;
                    case 'E':
                        System.out.println("Micro processors, Logic switching theory");
                        break;
                    case 'M':
                        System.out.println("Drawing, Manufacturing Machines");
                        break;
                    default:
                        System.out.println("Invalid branch");
                        break;
                }
                break;
            case 3:
                switch (branch) // LINE D
                {
                    case 'C':
                        System.out.println("Operating System, RDBMS");
                        break;
                    case 'E':
                        System.out.println("Fundamentals of Logic Design, Microelectronics");
                        break;
                    case 'Z':
                        System.out.println("Internal Combustion Engines, Mechanical Vibration");
                        break;
                    default:
                        System.out.println("Invalid branch");
                        break;
                }
                break;
            default:
                System.out.println("Invalid year");
                break;

        }

    }

}
