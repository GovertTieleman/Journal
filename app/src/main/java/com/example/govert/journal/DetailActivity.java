package com.example.govert.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // get retrievedEntry
        JournalEntry currentEntry = (JournalEntry) getIntent().getSerializableExtra("clickedEntry");

        // set date, title, mood and entry
        TextView dateView = (TextView) findViewById(R.id.dateTextView);
        dateView.setText(currentEntry.getDate());

        TextView titleView = (TextView) findViewById(R.id.titleTextView);
        titleView.setText(currentEntry.getTitle());

        TextView moodView = (TextView) findViewById(R.id.moodTextView);
        moodView.setText(currentEntry.getMood());

        TextView entryView = (TextView) findViewById(R.id.entryTextView);
        entryView.setText(currentEntry.getEntry());
    }
}
