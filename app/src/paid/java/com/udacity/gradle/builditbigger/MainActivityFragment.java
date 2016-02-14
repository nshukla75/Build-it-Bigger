package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.jokedisplay.JokeDisplayActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokeListener{
    private ProgressBar mSpinner;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button button = (Button) root.findViewById(R.id.joke_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startJokeActivity();
            }
        });
        mSpinner = (ProgressBar) root.findViewById(R.id.progressBar);
        return root;
    }
    @Override
    public void onReceived(String joke) {
        mSpinner.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(getActivity(), JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.INTENT_JOKE, joke);
        this.startActivity(intent);
    }
    public void startJokeActivity(){
        mSpinner.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask().execute(this);
    }
}
