package com.example.govert.journal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // get retrievedEntry
        JournalEntry currentEntry = (JournalEntry) getIntent().getSerializableExtra("entry");

        // set date, title, mood and entry
        TextView dateView = (TextView) findViewById(R.id.dateTextView);
        Date date = currentEntry.getDate();
        DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
        String dateString = dateFormat.format(date);
        dateView.setText(dateString);

        TextView titleView = (TextView) findViewById(R.id.titleTextView);
        titleView.setText(currentEntry.getTitle());

        TextView moodView = (TextView) findViewById(R.id.moodTextView);
        moodView.setText(currentEntry.getMood());

        TextView entryView = (TextView) findViewById(R.id.entryTextView);
        entryView.setText(currentEntry.getEntry());
    }
}
