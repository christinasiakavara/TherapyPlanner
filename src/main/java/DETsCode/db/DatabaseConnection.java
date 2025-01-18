package DETsCode.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private final Connection connection;

    private static final String jdbcUrl = System.getenv("DB_URL");
    private static final String dbUsername = System.getenv("DB_USERNAME");
    private static final String dbPassword = System.getenv("DB_PASSWORD");

    private DatabaseConnection() {
        try {
            this.connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
            throw new RuntimeException(e);
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws SQLException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new SQLException("Could not close connection with the Database Server: " + e.getMessage());
        }
    }
}
