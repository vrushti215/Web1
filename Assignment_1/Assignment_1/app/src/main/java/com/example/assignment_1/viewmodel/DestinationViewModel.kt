package com.example.assignment_1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment_1.model.Destination

class DestinationViewModel : ViewModel() {
    private val _destinationDetails = MutableLiveData<Destination>()
    val destinationDetails: LiveData<Destination> = _destinationDetails

    fun selectDestination(destination: Destination) {
        _destinationDetails.value = destination
    }
}
