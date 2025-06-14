package feedtheneedy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/feedtheneedy?useSSL=false";
  // Replace 'feed_the_needy' with your database name
    private static final String USERNAME = "root";  // Replace with your database username
    private static final String PASSWORD = "root";  // Replace with your database password

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Ensure the driver class is loaded
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);  // Get the connection
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        }
        return conn;  // Return the connection object
    }
}
