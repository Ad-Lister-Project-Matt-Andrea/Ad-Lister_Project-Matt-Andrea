package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public void insert(Ad ad) {
        try {
            StringBuilder insertQuery = new StringBuilder("INSERT INTO ads_categories(ad_id, category_id) VALUES ");
            insertQuery.append("(?, ?), ".repeat(Math.max(0, ad.getCategories().size()-1)));
            insertQuery.append("(?, ?);");

            PreparedStatement stmt = connection.prepareStatement(insertQuery.toString());
            int i = 0;
            for (String category: ad.getCategories()) {
                long catId = getCategoryId(category);
                stmt.setLong(++i, ad.getId());
                stmt.setLong(++i, catId);
            }
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

    //if we had a categories dao this would go there
    public List<Category> getCategoriesFromCategoryNames(String[] names){
        //loop through category names create category for each one and return a list of categories
        List<Category> categories = new ArrayList<>();
        int counter = 1;
        for (String name: names) {
            categories.add(new Category(counter, name));
            counter ++;
        }
        return categories;
        //have at least three categories
        //for each name in names use a query
        //clean up later
    }
}
