package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, price, location) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setDouble(4, ad.getPrice());
            stmt.setString(5, ad.getLocation());
            //loop through categories for the new ad
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
//        List <Category> category = getAdCategories(adId)
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getString("location")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public List<Ad> returnSearchResults(String searchQuery) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ymir_matt.ads WHERE title LIKE ? OR description LIKE ?");
            stmt.setString(1, "%" + searchQuery + "%");
            stmt.setString(2, "%" + searchQuery + "%");
            ResultSet rs = stmt.executeQuery();

            List<Ad> searchResults = new ArrayList<>();
            while (rs.next()) {
                Ad ad = new Ad();
                ad.setTitle(rs.getString("title"));
                ad.setDescription(rs.getString("description"));
                searchResults.add(ad);
            }
            return searchResults;
        } catch (SQLException e) {
            System.out.println("Error fetching results");
            return null;
        }
    }


    @Override
    public List<Ad> usersAds(Long userID) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ymir_matt.ads INNER JOIN ymir_matt.users ON ads.user_id = users.id WHERE ads.user_id = ?");
            stmt.setLong(1, userID);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public Ad findById(Long id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ad ad = null;

        try {
            stmt = connection.prepareStatement("SELECT * FROM ymir_matt.ads WHERE id = ?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                ad = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("location")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad information", e);
        }
        return ad;
    }





    public void update(Ad ad) {
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("UPDATE ymir_matt.ads SET user_id = ?, title = ?, description = ?, price = ?, location = ? WHERE id = ?");
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setDouble(4, ad.getPrice());
            stmt.setString(5,ad.getLocation());
            stmt.setLong(6, ad.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating ad information", e);
        }
    }



    public void delete(Ad ad) {
        PreparedStatement stmt = null;

        try{
            stmt = connection.prepareStatement("DELETE FROM ymir_matt.ads WHERE id= ?");
            stmt.setLong(1, ad.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating ad information", e);
        }
    }


    public ArrayList<Category> getAdCategories(long adId) {
        ArrayList<Category> categories = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement("SELECT * FROM ymir_matt.ads_categories inner join select * \n" +
                    "from ad_category ac \n" +
                    "inner join categories c on ac.category_id = c.id \n" +
                    "WHERE ad_id = ?");
            stmt.setLong(1, adId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Category category = new Category(rs.getLong("id") ,rs.getString("category"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(categories);
        return categories;
    }


}

