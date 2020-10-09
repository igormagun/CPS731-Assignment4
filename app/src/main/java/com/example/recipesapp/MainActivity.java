package com.example.recipesapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This activity will display a splash screen and play audio for 5 seconds before opening the
 * recipe list
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;

        // TODO: Play the audio

        // Schedule the TimerTask that will stop the audio and switch activities
        Timer timer = new Timer();
        TimerTask switchActivities = new TimerTask() {
            @Override
            public void run() {
                // TODO: Stop playing the audio
                finish();
                startActivity(new Intent(context, RecipeListActivity.class));
            }
        };
        timer.schedule(switchActivities, 5000);
    }
}