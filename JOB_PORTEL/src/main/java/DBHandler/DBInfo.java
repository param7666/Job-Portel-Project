package DBHandler;

public class DBInfo {
    // Database connection details
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl"; // Replace with your database URL
    private static final String USERNAME = "parmeshwar"; // Replace with your username
    private static final String PASSWORD = "12345"; // Replace with your password

    // Getter methods for connection details
    public static String getDbUrl() {
        return DB_URL;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}


