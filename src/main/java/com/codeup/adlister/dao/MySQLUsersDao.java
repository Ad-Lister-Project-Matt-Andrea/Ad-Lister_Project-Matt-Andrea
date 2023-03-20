package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String username) {
        String query = "SELECT * FROM ymir_matt.users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

//    @Override
//    public Long insert(User user) {
//        String query = "INSERT INTO ymir_matt.users(username, email, password) VALUES (?, ?, ?)";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            stmt.setString(1, user.getUsername());
//            stmt.setString(2, user.getEmail());
//            stmt.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating new user", e);
//        }
//    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }


    @Override
    public long insert(String username, String password, User user) {
        String query = "SELECT COUNT(*) AS count FROM ymir_matt.users WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getInt("count") > 0) {
                return -1;
            } else {
                String query2 = "INSERT INTO ymir_matt.users(username, email, password) VALUES (?, ?, ?)";
                try {
                    PreparedStatement pstmt = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1, user.getUsername());
                    pstmt.setString(2, user.getEmail());
                    pstmt.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
                    pstmt.executeUpdate();
                    ResultSet rs2 = pstmt.getGeneratedKeys();
                    rs2.next();
                    return rs2.getLong(1);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException ex) {
            return -1;
        }
    }


    public void update(User user){
            String sqlUpdate = "UPDATE ymir_matt.users SET username = ? , email = ? WHERE id = ?";
            PreparedStatement pstmt = null;
            try {
                pstmt = connection.prepareStatement(sqlUpdate);
                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getEmail());
                pstmt.setLong(3,user.getId());
                pstmt.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }






}
