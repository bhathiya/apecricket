package com.kade.apecricket.dao;

import com.kade.apecricket.bean.Player;
import com.kade.apecricket.util.Constants;
import com.kade.apecricket.util.DatabaseUtils;
import com.kade.apecricket.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {

    public void addPlayers(Player[] players) throws Exception {
        String query = "insert into " + Constants.Tables.tablePlayers
                       + " (name, country_id) values (?,?)";
        Connection connection = DatabaseUtils.getConnection();
        if (connection == null) {
            throw new Exception("Database connection is null.");
        }
        PreparedStatement statement = connection.prepareStatement(query);
        for (Player player : players) {
            statement.setString(1, player.getName());
            statement.setInt(2, Utils.getCountryId(player.getCountry()));
            statement.addBatch();
        }
        statement.executeBatch();
        statement.close();
        connection.close();
    }

    public List<Player> getPlayers() throws Exception {
        String query = "SELECT name, country_id from " + Constants.Tables.tablePlayers;
        Connection connection = DatabaseUtils.getConnection();
        if (connection == null) {
            throw new Exception("Database connection is null.");
        }
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Player> players = new ArrayList<Player>();
        while (resultSet.next()) {
            Player player = new Player();
            player.setName(resultSet.getString("name"));
            player.setCountry(Utils.getCountryNameById(resultSet.getInt("country_id")));
            players.add(player);
        }
        statement.close();
        connection.close();
        return players;
    }
}
