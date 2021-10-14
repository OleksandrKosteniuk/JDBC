import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class TestJDBC {

    @Test
    public void getUserData() throws SQLException {

        String URL = "jdbc:mysql://localhost:3306/mydatabase";
        String USERNAME = "user";
        String PASSWORD = "parol";

        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("Connecting database...");

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM user");
            rs.last();

            System.out.println("Number of rows: " + rs.getRow());

            Assert.assertTrue(rs.getRow()>0,"User table does not contain any records");
            
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Test
    public void getSalaryData() throws SQLException {

        String URL = "jdbc:mysql://localhost:3306/mydatabase";
        String USERNAME = "user";
        String PASSWORD = "parol";

        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("Connecting database...");

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM salary");
            rs.last();

            System.out.println("Number of rows: " + rs.getRow());

            Assert.assertTrue(rs.getRow()>0,"Salary table does not contain any records");

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
}    

