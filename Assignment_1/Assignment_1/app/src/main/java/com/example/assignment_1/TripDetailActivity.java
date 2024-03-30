package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TripDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);

        // Get the views
        ImageView tripImageView = findViewById(R.id.tripImageView);
        TextView tripDestinationTextView = findViewById(R.id.tripDestinationTextView);
        TextView tripDatesTextView = findViewById(R.id.tripDatesTextView);
        TextView tripDescriptionTextView = findViewById(R.id.tripDescriptionTextView);

        // Retrieve the trip details from the intent
        Intent intent = getIntent();
        String destination = intent.getStringExtra("tripDestination");
        String startDate = intent.getStringExtra("tripStartDate");
        String endDate = intent.getStringExtra("tripEndDate");
        int imageResource = intent.getIntExtra("tripImageResource", R.drawable.img); // default_image is a placeholder in case no image is provided

        // Set the trip details to the views
        tripImageView.setImageResource(imageResource);
        tripDestinationTextView.setText(destination);
        tripDatesTextView.setText(String.format("%s - %s", startDate, endDate));
        tripDescriptionTextView.setText(intent.getStringExtra("tripDescription")); // Assuming you pass this extra

        // Implement the "Back" option
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        // This method is called when the Up (Back) button is pressed on the action bar
        onBackPressed();
        return true;
    }
}
