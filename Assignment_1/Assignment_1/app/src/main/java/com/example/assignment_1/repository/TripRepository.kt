package com.example.assignment_1.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.assignment_1.dao.TripDao
import com.example.assignment_1.model.Trip
import com.example.assignment_1.AppDatabase

class TripRepository(application: Application?) {
    private val tripDao: TripDao

    init {
        val db: AppDatabase = AppDatabase.getDatabase(application)
        tripDao = db.tripDao()
    }

    fun getTripById(tripId: Int): LiveData<Trip> {
        return tripDao.getTripById(tripId)
    }
}
