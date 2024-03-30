package com.example.assignment_1.network;

import com.example.assignment_1.model.User;
import com.example.assignment_1.model.Booking;
import com.example.assignment_1.model.Trip;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface WebServiceApi {

    @GET("user/{userId}")
    Call<User> getUserDetails(@Path("userId") int userId);

    @Streaming
    @GET
    Call<ResponseBody> downloadFile(@Url String fileUrl);

    @GET("bookings/{userId}")
    Call<List<Booking>> getBookingsForUser(@Path("userId") int userId);

    @POST("bookings/new")
    Call<Booking> createBooking(@Body Booking booking);

    // New Trip-related API calls
    @GET("trips")
    Call<List<Trip>> getAllTrips();

    @POST("trips/new")
    Call<Trip> createTrip(@Body Trip trip);

    Call<List<Trip>> getTrips();
}
