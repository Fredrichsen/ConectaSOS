package br.gov.conectasos.util;

import java.sql.*;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/conectasos?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "senha";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL não encontrado.", e);
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
} 