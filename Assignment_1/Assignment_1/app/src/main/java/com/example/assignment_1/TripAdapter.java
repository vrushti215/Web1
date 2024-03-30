package com.example.assignment_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_1.model.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    private static List<Trip> trips;
    private OnTripClickListener listener;

    // Constructor is updated to include the click listener
    public TripAdapter(List<Trip> trips) {
        this.trips = trips;
        this.listener = listener;
    }

    public TripAdapter(ArrayList<Trip> trips, OnTripClickListener onTripClickListener) {
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.destination_item, parent, false);
        return new TripViewHolder(view, listener); // Pass listener to the ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        Trip trip = trips.get(position);
        holder.bind(trip); // Bind trip data to the holder
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    static class TripViewHolder extends RecyclerView.ViewHolder {
        TextView tripDestinationTextView;
        TextView tripDatesTextView;

        TripViewHolder(View itemView, OnTripClickListener listener) {
            super(itemView);
            tripDestinationTextView = itemView.findViewById(R.id.tripDestinationTextView);
            tripDatesTextView = itemView.findViewById(R.id.tripDatesTextView);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onTripClick(trips.get(position));
                }
            });
        }

        void bind(Trip trip) {
            tripDestinationTextView.setText(trip.getDestination());
            tripDatesTextView.setText(trip.getStartDate() + " - " + trip.getEndDate());
        }
    }
    public interface OnTripClickListener {
        void onTripClick(Trip trip);

    }
}


