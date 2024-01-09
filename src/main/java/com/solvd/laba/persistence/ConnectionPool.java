package com.solvd.laba.persistence;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
    private static final String CONFIG_FILE = "config.properties";

    private static List<Connection> connectionPool = new ArrayList<>();

    static {
        try {
            Properties config = loadConfig();
            String url = config.getProperty("url");
            String user = config.getProperty("username");
            String password = config.getProperty("password");
            String driver = config.getProperty("driver");
            int poolSize = Integer.parseInt(config.getProperty("poolSize"));

            Class.forName(driver);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                connectionPool.add(connection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static Properties loadConfig() {
        Properties properties = new Properties();
        try (InputStream input = ConnectionPool.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("Unable to find " + CONFIG_FILE);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error loading configuration", e);
        }
        return properties;
    }

    public static Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            throw new SQLException("Connection pool exhausted");
        }

        return connectionPool.remove(connectionPool.size() - 1);
    }

    public static void releaseConnection(Connection connection) {
        connectionPool.add(connection);
    }

    public static void closeConnections() throws SQLException {
        for (Connection connection : connectionPool) {
            connection.close();
        }
        connectionPool.clear();
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            // Use the connection as needed
            System.out.println("Connected to the database!");

            // Release the connection when done
            releaseConnection(connection);

            // Close all connections (optional)
            closeConnections();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
