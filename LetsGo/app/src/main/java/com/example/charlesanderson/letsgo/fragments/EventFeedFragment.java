package com.example.charlesanderson.letsgo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.charlesanderson.letsgo.views.EventListAdapter;
import com.example.charlesanderson.letsgo.views.GradientDecoration;
import com.example.charlesanderson.letsgo.R;
import com.example.charlesanderson.letsgo.models.Event;
import com.example.charlesanderson.letsgo.models.User;
import com.example.charlesanderson.letsgo.viewmodels.EventFeedViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFeedFragment extends androidx.fragment.app.Fragment {

    public List<Event> events;
    public EventFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_feed, container, false);
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        events = new ArrayList<Event>();
        final RecyclerView recyclerView = view.findViewById(R.id.eventListView);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GradientDecoration(getContext()));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).navigate(R.id.action_eventFeedFragment_to_createEventFragment);
            }
        });
        initEvents();
        EventFeedViewModel viewModel = ViewModelProviders.of(getActivity()).get(EventFeedViewModel.class);
        LiveData<List<Event>> liveData = viewModel.getEventList();
        final EventListAdapter adapter = new EventListAdapter(events);
        recyclerView.setAdapter(adapter);

        liveData.observe((LifecycleOwner) getActivity(), new Observer<List<Event>>() {
            @Override
            public void onChanged(List<Event> liveEvents) {
                if(liveEvents!=null) {
                    adapter.setEvents(liveEvents);
                }
            }
        });
        return view;
    }

    public void initEvents()  {
        for (int i = 0; i<14; i++) {
            int x = (int)(Math.random()*100000000);
            Event e = new Event("event "+x, "Today at 5pm", new User("charlie", "anderson"));
            if(i%3==0) {
                e.setImageId(R.drawable.fatpika);
            }
            if(i%4==0) {
                e.setImageId(R.drawable.square);
            }
            events.add(e);
        }
    }

}
