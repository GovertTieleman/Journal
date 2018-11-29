package com.example.govert.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void submitEntry(View view) {
        // get entryDate
        Format formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date = Calendar.getInstance().getTime();
        String entryDate = formatter.format(date);

        // get title, mood and entry from views
        EditText titleEditText = findViewById(R.id.titleEditText);
        String titleText = titleEditText.getText().toString();

        EditText moodEditText = findViewById(R.id.moodEditText);
        String moodText = moodEditText.getText().toString();

        EditText entryEditText = findViewById(R.id.entryEditText);
        String entryText = entryEditText.getText().toString();

        // create entry object
        JournalEntry entry = new JournalEntry(null, entryDate, titleText, moodText, entryText);

        // get db
        EntryDatabaseHelper db = EntryDatabaseHelper.getInstance(this.getApplicationContext());

        // insert into db
        db.insert(entry);

        // go back to MainActivity
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}
