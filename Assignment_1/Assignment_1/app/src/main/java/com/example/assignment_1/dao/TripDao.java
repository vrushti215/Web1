package com.example.assignment_1.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.assignment_1.model.Trip;

@Dao
public interface TripDao {
    @Query("SELECT * FROM trips WHERE tripId = :tripId")
    LiveData<Trip> getTripById(int tripId);
}
