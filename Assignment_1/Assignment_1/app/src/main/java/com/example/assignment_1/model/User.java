package com.example.assignment_1.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int userId;

    private String name;
    private String email;
    private String profilePictureUrl; // Additional detail for user profile picture
    private String bio; // Additional detail for user biography

    // Updated Constructor to include parameters
    public User(String name, String email, String profilePictureUrl, String bio) {
        this.name = name;
        this.email = email;
        this.profilePictureUrl = profilePictureUrl;
        this.bio = bio;
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public String getBio() {
        return bio;
    }

    // Setters
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
