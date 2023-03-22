package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.ArrayList;
import java.util.List;

public interface AdsCategories {
    void insert (Ad ad);
    ArrayList<Category> all();
    ArrayList<Category> findByIds(ArrayList<Long> ids);
    long getCategoryId(String category);
    List<Category> getCategoriesFromCategoryNames(String[] names);
}
