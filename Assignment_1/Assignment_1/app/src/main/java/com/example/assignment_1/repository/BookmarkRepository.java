package com.example.assignment_1.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.example.assignment_1.AppDatabase;
import com.example.assignment_1.model.Trip;
import com.example.assignment_1.dao.BookmarkTripDao;

import java.util.List;

public class BookmarkRepository {
    private BookmarkTripDao bookmarkTripDao;
    private LiveData<List<Trip>> allBookmarkedTrips;

    public BookmarkRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        bookmarkTripDao = db.bookmarkTripDao();
        allBookmarkedTrips = bookmarkTripDao.getAllBookmarkedTrips();
    }

    public LiveData<List<Trip>> getAllBookmarkedTrips() {
        return allBookmarkedTrips;
    }

    public void updateTripBookmarkStatus(Trip trip) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            bookmarkTripDao.updateTripBookmarkStatus(trip);
        });
    }
}
