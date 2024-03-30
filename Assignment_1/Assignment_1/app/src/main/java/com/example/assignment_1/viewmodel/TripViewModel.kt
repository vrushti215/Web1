package com.example.assignment_1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment_1.model.Trip

class TripViewModel : ViewModel() {
    private val _selectedTrip = MutableLiveData<Trip>()
    val selectedTrip: LiveData<Trip> = _selectedTrip

    fun loadTrip(tripId: String) {
        // Placeholder for loading trip details
        _selectedTrip.value = Trip("London", "2021-07-20", "2021-07-25")
    }
}
