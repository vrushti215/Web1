package com.example.assignment_1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment_1.model.Trip
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _tripsLiveData = MutableLiveData<List<Trip>?>()
    val tripsLiveData: MutableLiveData<List<Trip>?> = _tripsLiveData

    init {
        loadTrips()
    }

    private fun loadTrips() {
        // Simulated initial trips. In a real app, fetch these from your database.
        val trips = listOf(
            Trip("Paris", "2021-04-15", "2021-04-20").apply { tripId = 1 },
            Trip("New York", "2021-05-10", "2021-05-15").apply { tripId = 2 },
            Trip("Tokyo", "2021-06-05", "2021-06-10").apply { tripId = 3 }
        )
        _tripsLiveData.value = trips
    }

    fun addTrip(trip: Trip) {
        val updatedList = ArrayList(_tripsLiveData.value ?: emptyList())
        updatedList.add(trip)
        _tripsLiveData.value = updatedList
    }

    fun removeTrip(tripId: Int) {
        val updatedList = ArrayList(_tripsLiveData.value ?: emptyList())
        updatedList.removeAll { it.tripId == tripId }
        _tripsLiveData.value = updatedList
    }

    fun updateTrip(updatedTrip: Trip) {
        val updatedList = ArrayList(_tripsLiveData.value ?: emptyList())
        val index = updatedList.indexOfFirst { it.tripId == updatedTrip.tripId }
        if (index != -1) {
            updatedList[index] = updatedTrip
            _tripsLiveData.value = updatedList
        }
    }

    fun toggleBookmark(tripId: Int) {
        _tripsLiveData.value?.let { trips ->
            val updatedTrips = trips.map { if (it.tripId == tripId) it.apply { isBookmarked = !isBookmarked } else it }
            _tripsLiveData.value = updatedTrips
        }
    }

    fun filterTripsByDestination(destination: String) {
        viewModelScope.launch {
            val filteredTrips = _tripsLiveData.value?.filter { it.destination.contains(destination, ignoreCase = true) }
            _tripsLiveData.postValue(filteredTrips)
        }
    }
}
