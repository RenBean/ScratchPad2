package week4.day2;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Ari on 8/2/16.
 */
public class MonkeyPooRegestry {
    private String mName;
    private String mDate;
    private String note;


    static final String JDBC_DRIVER = "org.hsqldb.jdbcDriver";
    static final String DB_URL = "jdbc:hsqldb:registry_file";
    static final String USER = "dumbMonkey";
    static final String PASS = "";


    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement stmt = null;
        try {
            //STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query

            stmt = con.prepareStatement("INSERT INTO monkey_registry (mName, mDate, note) VALUES (?, ?, ?)");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Add your name to the registry [ADD/VIEW]");
            String monkeyUser = scanner.nextLine();
            MonkeyPooRegestry mpr = new MonkeyPooRegestry();

            if (monkeyUser.equalsIgnoreCase("add")) {
                System.out.println("What is your name?");
                mpr.setmName(scanner.nextLine());
                System.out.println("What is the date?");
                mpr.setmDate(scanner.nextLine());
                System.out.println("Add a note?");
                mpr.setNote(scanner.nextLine());

                stmt.setString(1, mpr.getmName()); //first ?, =
                stmt.setString(2, mpr.getmDate()); // second ?, =
                stmt.setString(3, mpr.getNote());
                stmt.executeUpdate();
            }
            if (monkeyUser.equalsIgnoreCase("view")) {

            }

            //STEP 4: Clean-up environment
            stmt.close();
            con.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Thank You!");
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
