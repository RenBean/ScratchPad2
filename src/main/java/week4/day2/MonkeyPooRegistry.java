package week4.day2;

import java.sql.*;
import java.util.Scanner;

import static week4.day2.MonkeyPooTableCreator.monkeyPooTableCreator;
import static week4.day2.MonkeyPooTableQuery.monkeyPooTableQuery;

/**
 * Created by Ari on 8/2/16.
 */
public class MonkeyPooRegistry {
    private String monkeyName;
    private String monkeyDate;
    private String monkeyNote;
    private String monkeyIn;
    private String monkeyOut;


    static final String JDBC_DRIVER = "org.hsqldb.jdbcDriver";
    static final String DB_URL = "jdbc:hsqldb:registry_file";
    static final String USER = "dumbMonkey";
    static final String PASS = "";


    public static void main(String[] args) {

        Connection con = null;

        try {
            //STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(DB_URL, USER, PASS);



            Scanner scanner = new Scanner(System.in);
            System.out.println("Guest Registry!!! \nAccess options: [SIGN IN/SIGN OUT/VIEW]");
            String monkeyUser = scanner.nextLine();
            MonkeyPooRegistry mpr = new MonkeyPooRegistry();

            if (monkeyUser.equalsIgnoreCase("monkeypoo")){
                monkeyPooTableCreator();
            }

            if (monkeyUser.equalsIgnoreCase("sign out")){
                PreparedStatement signOut = con.prepareStatement("UPDATE monkey_registry SET monkeyOut = ? WHERE monkeyName = ?");
                System.out.println("Verify your name?");
                mpr.setMonkeyName(scanner.nextLine());
                System.out.println("Departure Time?");
                mpr.setMonkeyOut(scanner.nextLine());
                signOut.setString(1, mpr.getMonkeyOut());
                signOut.setString(2, mpr.getMonkeyName());
                signOut.executeUpdate();
                System.out.println("Enjoy the rest of your day!");
                signOut.close();
            }

            if (monkeyUser.equalsIgnoreCase("sign in")) {
                PreparedStatement signIn = con.prepareStatement("INSERT INTO monkey_registry (monkeyName, monkeyDate, monkeyNote, monkeyIn) VALUES (?, ?, ?, ?)");
                System.out.println("What is your name?");
                mpr.setMonkeyName(scanner.nextLine());
                System.out.println("What is the date?");
                mpr.setMonkeyDate(scanner.nextLine());
                System.out.println("Add a note?");
                mpr.setMonkeyNote(scanner.nextLine());
                System.out.println("Arrival Time?");
                mpr.setMonkeyIn(scanner.nextLine());

                signIn.setString(1, mpr.getMonkeyName()); //first ?, =
                signIn.setString(2, mpr.getMonkeyDate()); // second ?, =
                signIn.setString(3, mpr.getMonkeyNote());
                signIn.setString(4, mpr.getMonkeyIn());
                signIn.executeUpdate();
                System.out.println("Thank You!");
                signIn.close();
            }

            if (monkeyUser.equalsIgnoreCase("view")) {
                monkeyPooTableQuery();
            }


            //STEP 4: Clean-up environment

            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Connection Closed.");
    }

    public String getMonkeyName() {
        return monkeyName;
    }

    public void setMonkeyName(String monkeyName) {
        this.monkeyName = monkeyName;
    }

    public String getMonkeyDate() {
        return monkeyDate;
    }

    public void setMonkeyDate(String monkeyDate) {
        this.monkeyDate = monkeyDate;
    }

    public String getMonkeyNote() {
        return monkeyNote;
    }

    public void setMonkeyNote(String monkeyNote) {
        this.monkeyNote = monkeyNote;
    }

    public String getMonkeyIn() {
        return monkeyIn;
    }

    public void setMonkeyIn(String monkeyIn) {
        this.monkeyIn = monkeyIn;
    }

    public String getMonkeyOut() {
        return monkeyOut;
    }

    public void setMonkeyOut(String monkeyOut) {
        this.monkeyOut = monkeyOut;
    }
}
