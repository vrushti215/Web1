package com.example.assignment_1.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "bookings")
public class Booking {
    @PrimaryKey(autoGenerate = true)
    private int bookingId;

    private int userId;
    private int tripId;

    @NonNull
    private String confirmationNumber; // Additional detail
    private String specialRequests; // Additional detail, nullable

    // Constructor with all fields
    public Booking() {
        this.userId = userId;
        this.tripId = tripId;
        this.confirmationNumber = confirmationNumber;
        this.specialRequests = specialRequests;
    }

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getTripId() {
        return tripId;
    }

    @NonNull
    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    // Setters
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setConfirmationNumber(@NonNull String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }
}
