package com.codeup.adlister.dao;

public interface AdsCategories {
    void insert (long adId, long categoryId);
    long getCategoryId(String category);
}
