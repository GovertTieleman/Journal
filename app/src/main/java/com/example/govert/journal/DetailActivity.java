package com.example.govert.journal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
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

        ImageView moodView = (ImageView) findViewById(R.id.moodImageView);
        switch (currentEntry.getMood()) {
            case "happier":
                moodView.setImageResource(R.drawable.happier);
                break;
            case "happy":
                moodView.setImageResource(R.drawable.happy);
                break;
            case "sad":
                moodView.setImageResource(R.drawable.sad);
                break;
            case "sadder":
                moodView.setImageResource(R.drawable.sadder);
                break;
        }

        TextView entryView = (TextView) findViewById(R.id.entryTextView);
        entryView.setText(currentEntry.getEntry());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
