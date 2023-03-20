package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);
    long insert(String username, String password, User user);

    void update(User user);
}
