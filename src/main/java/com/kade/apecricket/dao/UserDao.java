package com.kade.apecricket.dao;

import com.kade.apecricket.bean.User;
import com.kade.apecricket.util.Constants;
import com.kade.apecricket.util.DatabaseUtils;
import com.kade.apecricket.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {

    public void registerUser(User user) throws Exception {
        String query = "INSERT INTO " + Constants.Tables.tableUsers
                       + " (username, password, email, phone, firstname, lastname) values (?,?,?,?,?,?)";
        Connection connection = DatabaseUtils.getConnection();
        if (connection == null) {
            throw new Exception("Database connection is null.");
        }
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getUsername());
        statement.setString(2, Utils.encrypt(user.getPassword()));
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPhone());
        statement.setString(5, user.getFirstName());
        statement.setString(6, user.getLastName());
        statement.execute();
        statement.close();
        connection.close();
    }

    public User loginUser(User guest) throws Exception {
        String query = "SELECT * from " + Constants.Tables.tableUsers
                       + " WHERE username = ?";
        Connection connection = DatabaseUtils.getConnection();
        if (connection == null) {
            throw new Exception("Database connection is null.");
        }
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, guest.getUsername());
        ResultSet resultSet = statement.executeQuery();
        User user = new User();
        if (resultSet.next()) {
            if (!Utils.encrypt(guest.getPassword()).equals(resultSet.getString("password"))) {
                throw new Exception("Login failed.");
            }
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPhone(resultSet.getString("phone"));
            user.setFirstName(resultSet.getString("firstname"));
            user.setLastName(resultSet.getString("lastname"));
        } else {
            statement.close();
            connection.close();
            throw new Exception("Login failed.");
        }
        statement.close();
        connection.close();
        return user;
    }

    public User getUser(String username) throws Exception {
        String query = "SELECT * from " + Constants.Tables.tableUsers;
        Connection connection = DatabaseUtils.getConnection();
        if (connection == null) {
            throw new Exception("Database connection is null.");
        }
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        User user = new User();
        if (resultSet.next()) {
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPhone(resultSet.getString("phone"));
            user.setFirstName(resultSet.getString("firstname"));
            user.setLastName(resultSet.getString("lastname"));
        } else {
            statement.close();
            connection.close();
            throw new Exception("User '" + username + "' not found.");
        }
        statement.close();
        connection.close();
        return user;
    }
}
