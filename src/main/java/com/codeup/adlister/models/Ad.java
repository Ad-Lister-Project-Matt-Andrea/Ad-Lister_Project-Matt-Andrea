package com.codeup.adlister.models;

import java.util.ArrayList;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;

    private double price;

    private String location;

    private ArrayList<Category> categories;



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Ad(long id, long userId, String title, String description, double price, String location, ArrayList<Category> categories) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.categories = categories;
    }

    public Ad(long id, long userId, String title, String description, double price, String location) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
    }

    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        if(userId < 1 ){
            throw new IllegalArgumentException("user-id cannot be less than 1!");
        }
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty!");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.isEmpty()){
            throw new IllegalArgumentException("Description cannot be empty!");
        }
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", categories=" + categories +
                '}';
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
