package toolBox.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Ari on 8/2/16.
 */
public class TestdbMinimum {

    public static void main(String[] args) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:db_file","sa","");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id,str_col,num_col FROM sample_table");
            while(rs.next()) {
                String rowResults = rs.getInt("id")+" -- "+rs.getString("str_col")+" -- "+rs.getInt("num_col");
                System.out.println(rowResults);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
