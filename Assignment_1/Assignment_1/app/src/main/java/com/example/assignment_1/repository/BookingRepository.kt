package com.example.assignment_1.repository

import android.content.Context
import com.example.assignment_1.AppDatabase
import com.example.assignment_1.network.BookingService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BookingRepository(private val context: Context) {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://your.api.endpoint/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val bookingService = retrofit.create(BookingService::class.java)
    private val bookingDao = AppDatabase.getDatabase(context).bookingDao()

    suspend fun bookTrip(tripId: Int): String {
        try {
            val response = bookingService.bookTrip(tripId)
            if (response.isSuccessful) {
                // Optionally, save booking details in local database
                // bookingDao.insert(Booking(...))
                return "Success"
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "Failure"
    }

    suspend fun downloadTicketDetails(tripId: Int): String {
        try {
            val response = bookingService.downloadTicketDetails(tripId)
            if (response.isSuccessful) {
                // Process and return ticket details
                // For example, saving to local database or processing the data
                return response.body() ?: "No Details"
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return "Failure"
    }
}
