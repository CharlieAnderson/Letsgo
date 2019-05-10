package com.example.charlesanderson.letsgo;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.charlesanderson.letsgo.models.Event;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {
    List<Event> events;

    public EventListAdapter(List<Event> events){
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card, parent, false);
        EventViewHolder viewHolder = new EventViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder viewHolder, int position) {
        viewHolder.textView.setText(events.get(position).getTitle());
        viewHolder.imageView.setImageResource(events.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView textView;
        ImageView imageView;


        EventViewHolder(View itemView) {
            super(itemView);
             view = itemView;
             textView = (TextView)itemView.findViewById(R.id.event_text);
             imageView = (ImageView)itemView.findViewById(R.id.event_image);
        }
    }
}

