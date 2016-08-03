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
                "dumbMonkey",  //un
                "");           //pw
    }

    public static void monkeyPooTableCreator() {

        MonkeyPooTableCreator registry = null;

        try {
            registry = new MonkeyPooTableCreator("registry_file");
        } catch (Exception ex1) {
            ex1.printStackTrace();

            return;
        }

        try {


            registry.update(
                    "CREATE TABLE monkey_registry (id INTEGER IDENTITY, monkeyName VARCHAR(20), monkeyDate VARCHAR(20), monkeyNote VARCHAR(30), monkeyIn VARCHAR(10), monkeyOut VARCHAR(10))");
        } catch (SQLException ex2) {

        }

        try {

            registry.update(
                    "INSERT INTO monkey_registry(monkeyName,monkeyDate,monkeyNote,monkeyIn,monkeyOut) VALUES('Bing', 'March 16, 2016', 'Great Fun!','9:20am','1:30pm')");
            registry.update(
                    "INSERT INTO monkey_registry(monkeyName,monkeyDate,monkeyNote,monkeyIn,monkeyOut) VALUES('Google', 'March 17, 2016', 'What was that?','10:00am','5:30pm')");

            registry.query("SELECT * FROM monkey_registry WHERE id < 100");
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
        st = con.createStatement();
        rs = st.executeQuery(expression);
        dump(rs);
        st.close();

    }
    public synchronized void update(String expression) throws SQLException {

        Statement st = null;
        st = con.createStatement();
        int i = st.executeUpdate(expression);
        if (i == -1) {
            System.out.println("registry error : " + expression);
        }
        st.close();
    }

    public static void dump(ResultSet rs) throws SQLException {
        ResultSetMetaData meta   = rs.getMetaData();
        int               colmax = meta.getColumnCount();
        int               i;
        Object            o = null;

        for (; rs.next(); ) {
            for (i = 0; i < colmax; ++i) {
                o = rs.getObject(i + 1);    // In SQL the first column is indexed with 1 not 0
                System.out.print(o.toString() + " ");
            }
            System.out.println(" ");
        }
    }

}

