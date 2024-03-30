package com.example.assignment_1.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.example.assignment_1.model.Trip;

import java.util.List;

@Dao
public interface BookmarkTripDao {
    // Fetch all bookmarked trips
    @Query("SELECT * FROM trips WHERE isBookmarked = 1")
    LiveData<List<Trip>> getAllBookmarkedTrips();

    // This method assumes you pass a Trip object with the updated bookmark status.
    // Typically, you retrieve a Trip, change its bookmark status, and then pass it here.
    @Update
    void updateTripBookmarkStatus(Trip trip);
}
