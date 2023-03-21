package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public interface AdsCategories {
    void insert (Ad ad);
    long getCategoryId(String category);
    List<Category> getCategoriesFromCategoryNames(String[] names);
}
