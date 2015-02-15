package com.kade.apecricket.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/apecricket";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        return conn;
    }
}
