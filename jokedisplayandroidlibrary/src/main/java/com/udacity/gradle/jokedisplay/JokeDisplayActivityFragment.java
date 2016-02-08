package com.udacity.gradle.jokedisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JokeDisplayActivityFragment extends Fragment {


    public JokeDisplayActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_joke_display_activity, container, false);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JokeDisplayActivity.INTENT_JOKE);
        TextView textViewJoke = (TextView) root.findViewById(R.id.joke_textview);
        if (joke != null && joke.length() != 0) {
            textViewJoke.setText(joke);
        }
        return root;
    }

}
