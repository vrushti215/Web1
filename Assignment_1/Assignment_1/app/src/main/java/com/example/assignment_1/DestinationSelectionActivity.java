package com.example.assignment_1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DestinationSelectionActivity extends AppCompatActivity {

    private EditText editTextDeparture, editTextDestination, editTextDepartureDate, editTextReturnDate;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_selection);

        editTextDeparture = findViewById(R.id.editTextDeparture);
        editTextDestination = findViewById(R.id.editTextDestination);
        editTextDepartureDate = findViewById(R.id.editTextDepartureDate);
        editTextReturnDate = findViewById(R.id.editTextReturnDate);
        buttonNext = findViewById(R.id.buttonNext);

        setupDatePicker(editTextDepartureDate);
        setupDatePicker(editTextReturnDate);

        buttonNext.setOnClickListener(view -> {
            if (validateInputs()) {
                // Proceed with your next action here, e.g., open the next activity
                Toast.makeText(DestinationSelectionActivity.this, "Validation Successful", Toast.LENGTH_SHORT).show();
                // Intent to open the next activity can go here
            }
        });
    }

    private void setupDatePicker(final EditText editText) {
        final Calendar calendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateSetListener = (view, year, monthOfYear, dayOfMonth) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel(editText, calendar);
        };

        editText.setOnClickListener(v -> new DatePickerDialog(DestinationSelectionActivity.this, dateSetListener,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show());
    }

    private void updateLabel(EditText editText, Calendar calendar) {
        String format = "yyyy-MM-dd"; // Choose your format
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format, java.util.Locale.US);
        editText.setText(sdf.format(calendar.getTime()));
    }

    private boolean validateInputs() {
        String fromDestination = editTextDepartureDate.getText().toString();
        String toDestination = editTextReturnDate.getText().toString();

        if(fromDestination.isEmpty() || toDestination.isEmpty()) {
            Toast.makeText(this, "Please fill in both destinations", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(fromDestination.equals(toDestination)) {
            Toast.makeText(this, "Departure and destination cannot be the same", Toast.LENGTH_SHORT).show();
            return false;
        }
        // Implement additional validation for dates if required
        // ...

        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
