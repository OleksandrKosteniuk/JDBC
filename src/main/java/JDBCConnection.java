import java.sql.*;

public class JDBCConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "parol";
        
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("Connecting database...");

        try {connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM user");
            rs.last();
            System.out.println("Number of rows: " + rs.getRow());
            
            //System.out.println("Database connected!");
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }
}
