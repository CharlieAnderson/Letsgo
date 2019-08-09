package com.example.charlesanderson.letsgo.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.charlesanderson.letsgo.database.FirebaseQueryLiveData;
import com.example.charlesanderson.letsgo.models.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class EventFeedViewModel extends ViewModel {
    private static final DatabaseReference EVENTS_REF = FirebaseDatabase.getInstance().getReference("/events");
    private final FirebaseQueryLiveData eventData = new FirebaseQueryLiveData(EVENTS_REF);
    public List<Event> eventList = new ArrayList<Event>();
    public MutableLiveData<List<Event>> EventListLiveData = new MutableLiveData<>();

    @NonNull
    public LiveData<DataSnapshot> getEventData() {
        return eventData;
    }

    @NonNull
    public LiveData<List<Event>> getEventList() { return EventListLiveData; }

    public LiveData<List<Event>> addEvent(Event event) {
        eventList.add(event);
        EventListLiveData.setValue(eventList);
        return EventListLiveData;
    }

}
