package com.codeup.adlister.dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLAdsCategoriesDao implements AdsCategories {

    private Connection connection;
    public MySQLAdsCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public void insert(long adId, long categoryId) {
        try {
            String insertQuery = "INSERT INTO ads_categories(ad_id, category_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setLong(1, adId);
            stmt.setLong(2, categoryId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error.", e);
        }
    }

    @Override
    public long getCategoryId(String category) {
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
            stmt = connection.prepareStatement("SELECT id FROM categories WHERE category = ?");
            stmt.setString(1, category);
            rs = stmt.executeQuery();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad information", e);
        }
    }
}
