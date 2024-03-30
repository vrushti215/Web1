package com.example.assignment_1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.assignment_1.repository.BookingRepository
import kotlinx.coroutines.launch

class BookingViewModel(application: Application) : AndroidViewModel(application) {
    private val bookingRepository = BookingRepository(application)

    // LiveData to observe booking status
    val bookingStatus = MutableLiveData<String>()
    // LiveData to observe ticket details once booking is confirmed
    val ticketDetails = MutableLiveData<String>()

    fun makeBooking(tripId: Int) {
        viewModelScope.launch {
            val bookingResult = bookingRepository.bookTrip(tripId)
            if (bookingResult == "Success") {
                // If booking is successful, update LiveData and proceed to fetch ticket details
                bookingStatus.postValue(bookingResult)
                downloadTicketDetails(tripId)
            } else {
                // If booking fails, update LiveData to reflect the failure
                bookingStatus.postValue("Failure")
            }
        }
    }

    private suspend fun downloadTicketDetails(tripId: Int) {
        val details = bookingRepository.downloadTicketDetails(tripId)
        // Update LiveData with ticket details
        ticketDetails.postValue(details)
    }
}
