package com.example.assignment_1.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.assignment_1.model.User;
import com.example.assignment_1.network.WebServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {
    private WebServiceApi webServiceApi;

    public UserRepository(Application application) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://your.api.base.url/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        webServiceApi = retrofit.create(WebServiceApi.class);
    }

    public LiveData<User> getUser(int userId) {
        final MutableLiveData<User> data = new MutableLiveData<>();
        webServiceApi.getUserDetails(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle failure
            }
        });
        return data;
    }
}
