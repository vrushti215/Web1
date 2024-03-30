package com.example.assignment_1.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.assignment_1.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    // Fetch all users
    @Query("SELECT * FROM users")
    LiveData<List<User>> getAllUsers();

    // Fetch a single user by email. Assuming email is unique, this query returns LiveData<User>.
    // If your logic could have multiple users with the same email, consider returning LiveData<List<User>> instead.
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    LiveData<User> getUserByEmail(String email);
}
