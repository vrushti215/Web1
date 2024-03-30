package com.example.assignment_1.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response

interface BookingService {
    @GET("bookTrip/{tripId}")
    suspend fun bookTrip(@Path("tripId") tripId: Int): Response<String>

    @GET("downloadTicket/{tripId}")
    suspend fun downloadTicketDetails(@Path("tripId") tripId: Int): Response<String>
}
