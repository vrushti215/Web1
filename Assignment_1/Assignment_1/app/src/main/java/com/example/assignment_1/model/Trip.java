package com.example.assignment_1.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
@Entity(tableName = "trips")
public class Trip {
    @PrimaryKey(autoGenerate = true)
    public int tripId;

    @NonNull
    public String destination;
    @NonNull
    public String startDate;
    @NonNull
    public String endDate;

    public boolean isBookmarked; // Field to support bookmarking feature

    // Constructor matching the parameters
    public Trip(@NonNull String destination, @NonNull String startDate, @NonNull String endDate) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isBookmarked = false; // Default value
    }

    // Getters and setters including new isBookmarked field
    public boolean isBookmarked() {
        return isBookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        isBookmarked = bookmarked;
    }

    // Getters and setters
    public int getId() {
        return tripId;
    }

    public void setId(int id) {
        this.tripId = id;
    }

    @NonNull
    public String getDestination() {
        return destination;
    }

    public void setDestination(@NonNull String destination) {
        this.destination = destination;
    }

    @NonNull
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(@NonNull String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(@NonNull String endDate) {
        this.endDate = endDate;
    }
}
