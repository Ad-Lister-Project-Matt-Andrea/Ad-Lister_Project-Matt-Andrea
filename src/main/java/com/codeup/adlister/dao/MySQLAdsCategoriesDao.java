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
    public ArrayList<Category> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ymir_matt.categories");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }

    @Override
    public ArrayList<Category> findByIds(ArrayList<Long> ids) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // TODO: Consider moving query building to helper func
            int length = ids.size();
            String query = "SELECT * FROM ymir_matt.categories WHERE id in (";
            StringBuilder queryBuilder = new StringBuilder(query);
            for (int i = 0; i < length; i++) {
                queryBuilder.append(" ?");
                if (i != length - 1)
                    queryBuilder.append(",");
            }
            queryBuilder.append(")");

            stmt = connection.prepareStatement(queryBuilder.toString());

            for (int i = 0; i < ids.size(); i++) {
                long id = ids.get(i);
                stmt.setLong(i + 1, id);
            }

            rs = stmt.executeQuery();

            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving category information", e);
        }
    }

    private ArrayList<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        ArrayList<Category> categories = new ArrayList<>();
        while (rs.next()) {
            Category category = new Category(rs.getLong("id") ,rs.getString("category"));
            categories.add(category);
        }
        return categories;
    }


    @Override
    public void insert(Ad ad) {
        try {
            StringBuilder insertQuery = new StringBuilder("INSERT INTO ads_categories(ad_id, category_id) VALUES ");
            insertQuery.append("(?, ?), ".repeat(Math.max(0, ad.getCategories().size()-1)));
            insertQuery.append("(?, ?);");

            PreparedStatement stmt = connection.prepareStatement(insertQuery.toString());
            int i = 0;
            for (Category cat:ad.getCategories()) {
                long catId = cat.getId();
                stmt.setLong(++i, ad.getId());
                stmt.setLong(++i, catId);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error inserting an ad_category.", e);
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
            throw new RuntimeException("Error retrieving category id information", e);
        }
    }

    //if we had a categories dao this would go there
    public List<Category> getCategoriesFromCategoryNames(String[] names){
        List<Category> categories = new ArrayList<>();
        int counter = 1;
        for (String name: names) {
            categories.add(new Category(counter, name));
            counter ++;
        }
        return categories;

    }
}
