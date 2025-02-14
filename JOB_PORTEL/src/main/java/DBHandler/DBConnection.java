package DBHandler;

import java.sql.*;

public class DBConnection {
    private static Connection connection;

    // Method to establish a connection
    public static Connection connect() {
        try {
            // Load the database driver (optional for modern JDBC versions)
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(DBInfo.getDbUrl(), DBInfo.getUsername(), DBInfo.getPassword());
           // System.out.println("Connection to the database was successful!");
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
        return connection;
    }

    // Method to close the connection
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the connection: " + e.getMessage());
        }
    }
}