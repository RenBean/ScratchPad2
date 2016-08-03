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

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            //STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            stmt = con.prepareStatement("SELECT id, mName, mDate, note FROM monkey_registry WHERE id < ?");
            stmt.setInt(1,100);
            ResultSet rs = stmt.executeQuery();

            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                String name  = rs.getString("mName");
                String note = rs.getString("note");
                String date = rs.getString("mDate");

                //Display values
                String resultString = "mName: " + name;
                resultString += ", mDate: " + date;
                resultString += ", note: " + note;
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
        System.out.println("Goodbye!");
    }

}
