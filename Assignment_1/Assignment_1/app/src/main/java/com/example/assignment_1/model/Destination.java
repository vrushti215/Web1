package com.example.assignment_1.model;

public class Destination {
    private final String name;
    private final String description;
    // Assuming you're using drawable resources. For URLs, you'd use a String.
    private final int imageResourceId;

    public Destination(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
