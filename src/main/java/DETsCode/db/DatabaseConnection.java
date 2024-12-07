package DETsCode.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private final Connection connection;

    private static final String jdbcUrl = System.getenv("DB_URL");
    private static final String dbUsername = System.getenv("DB_USERNAME");
    private static final String dbPassword = System.getenv("DB_PASSWORD");

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.c.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
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
}
