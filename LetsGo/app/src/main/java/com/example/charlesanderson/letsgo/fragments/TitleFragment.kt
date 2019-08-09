package com.example.charlesanderson.letsgo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.charlesanderson.letsgo.R
import kotlinx.android.synthetic.main.fragment_title.*
import kotlinx.android.synthetic.main.fragment_title.view.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TitleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TitleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(R.layout.fragment_title, container, false)

        view.LoginButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.loginFragment)
        }
        view.SignupButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.signupFragment)
        }

        return view
    }

}
