package com.example.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import android.widget.Toast;


public class TripSummaryActivity extends AppCompatActivity {

    private TextView textViewTripSummary;
    private Button buttonSave, buttonShare;
    private String tripSummaryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_summary);

        textViewTripSummary = findViewById(R.id.textViewTripSummary);
        buttonSave = findViewById(R.id.buttonSave);
        buttonShare = findViewById(R.id.buttonShare);

        // Example summary text
        tripSummaryText = "Trip Summary:\nDeparture: ...\nDestination: ...\nDates: ...";
        textViewTripSummary.setText(tripSummaryText);

        buttonSave.setOnClickListener(v -> saveToFile(tripSummaryText));

        buttonShare.setOnClickListener(v -> shareSummary(tripSummaryText));
    }

    private void saveToFile(String data) {
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "trip_summary.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes());
            // Notify the user that the file was successfully saved
            showToast("Summary saved to " + file.getAbsolutePath());
        } catch (IOException e) {
            showToast("Failed to save summary.");
            e.printStackTrace();
        }
    }

    private void shareSummary(String data) {
        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setText(data)
                .setChooserTitle("Share Trip Summary")
                .startChooser();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
