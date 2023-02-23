package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int userId;
//    private ArrayList<String> categories;

    public Ad() {   }

    public Ad(long id, String title, String description, int userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public Ad(String title, String description, int userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUser_id(int userId) {
        this.userId = userId;
    }

//    public ArrayList<String> getCategories() {
//        return categories;
//    }

//    public void setCategories(ArrayList<String> categories) {
//        this.categories = categories;
//    }
}
