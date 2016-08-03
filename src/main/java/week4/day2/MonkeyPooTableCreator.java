package week4.day2;

/**
 * Created by Ari on 8/2/16.
 */

import java.sql.*;


public class MonkeyPooTableCreator {

    Connection con;
    public MonkeyPooTableCreator(String registry_file_name_prefix) throws Exception {

        Class.forName("org.hsqldb.jdbcDriver");

        con = DriverManager.getConnection("jdbc:hsqldb:"
                        + registry_file_name_prefix,    // filenames
                "dumbMonkey",                     // username
                "");                      // password
    }

    public static void main(String[] args) {

        MonkeyPooTableCreator registry = null;

        try {
            registry = new MonkeyPooTableCreator("registry_file");
        } catch (Exception ex1) {
            ex1.printStackTrace();    // could not start db

            return;                   // bye bye
        }

        try {

            registry.update(
                    "CREATE TABLE monkey_registry ( id INTEGER IDENTITY, mName VARCHAR(25), mDate VARCHAR(12), note VARCHAR(250))");
        } catch (SQLException ex2) {

        }

        try {

            registry.update(
                    "INSERT INTO monkey_registry(mName,mDate,note) VALUES('Bing', '03032016', 'Great Fun!')");
            registry.update(
                    "INSERT INTO monkey_registry(mName,mDate,note) VALUES('Google', '03042016', 'What was that?')");

            // do a query
            registry.query("SELECT * FROM monkey_registry WHERE id < 100");

            // at end of program
            registry.shutdown();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
    }

    public void shutdown() throws SQLException {

        Statement st = con.createStatement();

        st.execute("SHUTDOWN");
        con.close();    // if there are no other open connection
    }

    //use for SQL command SELECT
    public synchronized void query(String expression) throws SQLException {

        Statement st = null;
        ResultSet rs = null;

        st = con.createStatement();         // statement objects can be reused with

        rs = st.executeQuery(expression);    // run the query

        // do something with the result set.
        dump(rs);
        st.close();    // NOTE!! if you close a statement the associated ResultSet is

    }

    //use for SQL commands CREATE, DROP, INSERT and UPDATE
    public synchronized void update(String expression) throws SQLException {

        Statement st = null;

        st = con.createStatement();    // statements

        int i = st.executeUpdate(expression);    // run the query

        if (i == -1) {
            System.out.println("db error : " + expression);
        }

        st.close();
    }

    public static void dump(ResultSet rs) throws SQLException {

        // the order of the rows in a cursor
        // are implementation dependent unless you use the SQL ORDER statement
        ResultSetMetaData meta   = rs.getMetaData();
        int               colmax = meta.getColumnCount();
        int               i;
        Object            o = null;

        for (; rs.next(); ) {
            for (i = 0; i < colmax; ++i) {
                o = rs.getObject(i + 1);    // Is SQL the first column is indexed

                // with 1 not 0
                System.out.print(o.toString() + " ");
            }

            System.out.println(" ");
        }
    }

}

