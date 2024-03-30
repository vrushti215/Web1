package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.model.Trip;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TripAdapter adapter;
    private ArrayList<Trip> trips; // Replace with the actual list of trips

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView and set its layout manager
        recyclerView = findViewById(R.id.destinationsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the list of trips
        trips = new ArrayList<>();
        // Populate the list with actual trip data
        initializeTrips();

        // Create an instance of TripAdapter with the trip list and a new OnTripClickListener
        adapter = new TripAdapter(trips, new TripAdapter.OnTripClickListener() {
            @Override
            public void onTripClick(Trip trip) {
                // Create an Intent to start TripDetailActivity
                Intent intent = new Intent(MainActivity.this, TripDetailActivity.class);
                // Put the trip details into the Intent
                intent.putExtra("tripDestination", trip.getDestination());
                intent.putExtra("tripStartDate", trip.getStartDate());
                intent.putExtra("tripEndDate", trip.getEndDate());
                // Start the TripDetailActivity
                startActivity(intent);
            }
        });

        // Set the adapter on the RecyclerView
        recyclerView.setAdapter(adapter);

        // Find the "Plan New Trip" button and set an OnClickListener to start DestinationSelectionActivity
        Button planTripButton = findViewById(R.id.button_plan_trip);
        planTripButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DestinationSelectionActivity.class);
            startActivity(intent);
        });
    }

    private void initializeTrips() {
        // This method should create Trip objects and add them to the 'trips' ArrayList
        // Example:
        trips.add(new Trip("Paris", "2021-04-15", "2021-04-20"));
        trips.add(new Trip("New York", "2021-05-10", "2021-05-15"));
        // Add more trips as necessary
    }
}
