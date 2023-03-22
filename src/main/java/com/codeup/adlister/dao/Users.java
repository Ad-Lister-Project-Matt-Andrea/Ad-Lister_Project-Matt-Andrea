package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);
    long insert(String username, String password, User user);
    User findById(Ad ad);

    void update(User user);
}
