package main.java.com.ServletTest.classes;

import java.sql.*;

public class DBConnector {

    private final String CONNECTION_URI =  "jdbc:jtds:sqlserver://ALINA-ПК/Lab10J;instance=SQLEXPRESS";




    public static final String USERNAME_COLUMN = "login";
    public static final String PASSWORD_COLUMN = "password";

    private final String SELECT_QUERY = "SELECT login, password FROM Users ";
    private final String INSERT_QUERY = "INSERT INTO Users (login, password) values (?, ?)";


    private String loginField;
    private String passwordField;

    public DBConnector(String username, String password){
        loginField = username;
        passwordField = password;
    }

    public void RegisterUser(Connection connection) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
        statement.setString(1, loginField);
        statement.setString(2, passwordField);
        statement.execute();
    }

    public Connection GetConnection() throws SQLException{
        return DriverManager.getConnection(CONNECTION_URI);
    }

    public ResultSet GetUsers(Connection connection) throws SQLException{
        return connection.createStatement().executeQuery(SELECT_QUERY + "WHERE login='" + loginField + "' AND password='" + passwordField + "'");
    }
}