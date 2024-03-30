package com.example.assignment_1.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.assignment_1.model.Booking;

@Dao
public interface BookingDao {
    @Insert
    void insert(Booking booking);

    @Update
    void update(Booking booking);

    @Delete
    void delete(Booking booking);

    @Query("SELECT * FROM bookings WHERE userId = :userId")
    List<Booking> getBookingsForUser(int userId);

    // Modified to include a @Query annotation for selecting all bookings
    @Query("SELECT * FROM bookings")
    LiveData<List<Booking>> getAllBookings();
}
