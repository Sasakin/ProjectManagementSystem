package project.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessionObject {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/developer_manager";
    private static final String user = "root";
    private static final String password = "sas2013";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static List<String> queryResult = new ArrayList<String>();

    public SessionObject() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void executQuery(String query) {  // Select
        queryResult.clear();
        try {
            // executing SELECT query
            rs = stmt.executeQuery(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void executUpdate(String query) {  // Remove Update Add
        queryResult.clear();
        try {
             stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public static ResultSet getResultSet() {
        return rs;
    }

    public List<String> getStringsByField(String field) {
        queryResult.clear();
        if(rs!=null) {
            try {
                while (rs.next()) {
                    queryResult.add(rs.getString(field));
                }
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
        return  queryResult;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        try { con.close(); } catch(SQLException se) { /*can't do anything */ }
        try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
    }
}
