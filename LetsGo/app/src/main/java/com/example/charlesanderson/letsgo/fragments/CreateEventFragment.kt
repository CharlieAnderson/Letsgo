package com.example.charlesanderson.letsgo.fragments


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.charlesanderson.letsgo.R
import com.example.charlesanderson.letsgo.models.Event
import com.example.charlesanderson.letsgo.models.User
import com.example.charlesanderson.letsgo.viewmodels.EventFeedViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.event_card.*
import kotlinx.android.synthetic.main.fragment_create_event.view.*
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.DateTimeParser
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.math.min
import kotlin.text.StringBuilder


/**
 * A simple [Fragment] subclass.
 *
 */
class CreateEventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_create_event, container, false)
        var dateSb = StringBuilder()
        val dateDialog = DatePickerDialog(context)
        var dateView = rootView.create_event_date

        dateView.setOnClickListener(){
            dateSb.clear()
            dateDialog.show()
        }

        val timeDialog = TimePickerDialog(context, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            dateSb.append("\nat ");
            var dateTime = DateTime().withTime(hourOfDay, minute, 0, 0)
            var timeFormatter = DateTimeFormat.forPattern("hh:mm aa")
            dateSb.append(timeFormatter.print(dateTime))
            dateView.setText(dateSb)
        }, 12, 0, false)

        dateDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
            var dateTime = DateTime().withDate(year, month+1, dayOfMonth)
            var dateFormatter = DateTimeFormat.forPattern("EEEE, MMMM dd, YYYY")
            dateSb.append(dateFormatter.print(dateTime))
            timeDialog.show()
        }

        activity!!.fab.setOnClickListener {
            if(rootView.create_event_title.text!=null && rootView.create_event_date.text!=null && rootView.create_event_date.text!=null) {
                val event = Event(rootView.create_event_title.text.toString(), rootView.create_event_date.text.toString(), User("charlie", "anderson"))
                val viewModel = ViewModelProviders.of(activity!!).get(
                    EventFeedViewModel::class.java
                )
                viewModel.addEvent(event);
                Navigation.findNavController(rootView).navigate(R.id.action_createEventFragment_to_eventFeedFragment)
            }
        }

        return rootView
    }


}
