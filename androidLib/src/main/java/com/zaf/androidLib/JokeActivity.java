package com.zaf.androidLib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static String JOKE_KEY = "Joke key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.activity_title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView tvJoke = findViewById(R.id.joke_textview);

        Intent intent = getIntent();
        if (intent.hasExtra(JOKE_KEY)){
            String jokeToDisplay = intent.getStringExtra(JOKE_KEY);
            tvJoke.setText(jokeToDisplay);
        }
    }

    // When the arrow is pressed on the action bar, close the activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
