package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TicketBookingActivity extends AppCompatActivity {

    private TextView textViewDeparture, textViewDestination, textViewDepartureDate, textViewReturnDate;
    private Button buttonBookTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_booking);

        // Initialize views
        textViewDeparture = findViewById(R.id.textViewDeparture);
        textViewDestination = findViewById(R.id.textViewDestination);
        textViewDepartureDate = findViewById(R.id.textViewDepartureDate);
        textViewReturnDate = findViewById(R.id.textViewReturnDate);
        buttonBookTrip = findViewById(R.id.buttonBookTrip);

        // Retrieve and display trip details passed from the previous activity
        Intent intent = getIntent();
        textViewDeparture.setText(intent.getStringExtra("departurePlace"));
        textViewDestination.setText(intent.getStringExtra("destinationPlace"));
        textViewDepartureDate.setText(intent.getStringExtra("departureDate"));
        textViewReturnDate.setText(intent.getStringExtra("returnDate"));

        // Handle book trip button click
        buttonBookTrip.setOnClickListener(v -> {
            // Here you can add your booking logic
            // For simplicity, this example just shows a message
            bookTrip();
        });
    }

    private void bookTrip() {
        // Implement the booking logic here
        // For demonstration, let's just navigate to the TripSummaryActivity
        Intent intent = new Intent(this, TripSummaryActivity.class);
        startActivity(intent);
    }
}
