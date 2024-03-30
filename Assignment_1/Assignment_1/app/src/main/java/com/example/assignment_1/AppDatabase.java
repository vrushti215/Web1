package com.example.assignment_1;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.assignment_1.dao.BookingDao;
import com.example.assignment_1.dao.BookmarkTripDao;
import com.example.assignment_1.dao.TripDao;
import com.example.assignment_1.dao.UserDao;
import com.example.assignment_1.model.Booking;
import com.example.assignment_1.model.Trip;
import com.example.assignment_1.model.User;

import java.util.concurrent.Executor;

// Ensure you've defined entities and version correctly
@Database(entities = {User.class,Trip.class, Booking.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static Executor databaseWriteExecutor;

    public abstract TripDao tripDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "your_database_name")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract BookingDao bookingDao();

    public abstract UserDao userDao();

    public abstract BookmarkTripDao bookmarkTripDao();
}
