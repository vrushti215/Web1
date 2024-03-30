package com.example.assignment_1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.assignment_1.model.Trip
import com.example.assignment_1.repository.TripRepository

class TripDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val tripRepository = TripRepository(application)
    private var tripDetails: LiveData<Trip>? = null

    fun getTripDetails(tripId: Int): LiveData<Trip>? {
        tripDetails = tripRepository.getTripById(tripId)
        return tripDetails
    }
}
