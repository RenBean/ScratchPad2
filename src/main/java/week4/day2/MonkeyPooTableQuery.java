package week4.day2;

import java.sql.*;

/**
 * Created by Ari on 8/2/16.
 */
public class MonkeyPooTableQuery {

    static final String JDBC_DRIVER = "org.hsqldb.jdbcDriver";
    static final String DB_URL = "jdbc:hsqldb:registry_file";
    static final String USER = "dumbMonkey";
    static final String PASS = "";

    public static void monkeyPooTableQuery() {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            //STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Accessing registry...");
            con = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            stmt = con.prepareStatement("SELECT id, monkeyName, monkeyDate, monkeyNote, monkeyIn, monkeyOut FROM monkey_registry WHERE id < ?");
            stmt.setInt(1,100);
            ResultSet rs = stmt.executeQuery();

            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                String monkeyName  = rs.getString("monkeyName");
                String monkeyDate = rs.getString("monkeyDate");
                String monkeyNote = rs.getString("monkeyNote");
                String monkeyIn = rs.getString("monkeyIn");
                String monkeyOut = rs.getString("monkeyOut");

                //Display values
                String resultString;
                resultString = "Name: " + monkeyName;
                resultString += ", Date: " + monkeyDate;
                resultString += ", Note: " + monkeyNote;
                resultString += ", In: " + monkeyIn;
                resultString += ", Out: " + monkeyOut;

                System.out.println(resultString);
            }
            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            con.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null)
                    stmt.close();
            } catch(SQLException se2) {
            } try {
                if(con!=null)
                    con.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Query complete...");
    }

}
