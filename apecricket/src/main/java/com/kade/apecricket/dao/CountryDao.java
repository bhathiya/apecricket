package com.kade.apecricket.dao;

import com.kade.apecricket.bean.Country;
import com.kade.apecricket.util.Constants;
import com.kade.apecricket.util.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDao {

    public void addCountries(Country[] countries) throws Exception {
        String query = "INSERT INTO " + Constants.Tables.tableCountries
                       + " (name) values (?)";
        Connection connection = DatabaseUtils.getConnection();
        if (connection == null) {
            throw new Exception("Database connection is null.");
        }
        PreparedStatement statement = connection.prepareStatement(query);
        for (Country country : countries) {
            statement.setString(1, country.getName());
        }
    }

    public List<Country> getCountries() throws Exception {
        String query = "SELECT id, name from " + Constants.Tables.tableCountries;
        Connection connection = DatabaseUtils.getConnection();
        if (connection == null) {
            throw new Exception("Database connection is null.");
        }
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Country> countries = new ArrayList<Country>();
        while (resultSet.next()) {
            Country country = new Country();
            country.setId(resultSet.getInt("id"));
            country.setName(resultSet.getString("name"));
            countries.add(country);
        }
        return countries;
    }
}
