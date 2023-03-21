package com.codeup.adlister.models;



public class Category {
    private String name;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public Category(long id) {
        this.id = id;
    }
}
