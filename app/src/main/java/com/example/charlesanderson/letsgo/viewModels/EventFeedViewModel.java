package com.example.charlesanderson.letsgo.viewModels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.charlesanderson.letsgo.database.FirebaseQueryLiveData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventFeedViewModel extends ViewModel {
    private static final DatabaseReference EVENTS_REF = FirebaseDatabase.getInstance().getReference("/events");
    private final FirebaseQueryLiveData eventData = new FirebaseQueryLiveData(EVENTS_REF);

    @NonNull
    public LiveData<DataSnapshot> getEventData() {
        return eventData;
    }

}
