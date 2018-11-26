package com.example.govert.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set listView
        ListView listView = (ListView) findViewById(R.id.entryList);

        // initialize entryList
        ArrayList<JournalEntry> entryList = new ArrayList<>();

        entryList.add(new JournalEntry(1, new Date(), "jemoeder", "kanker", "dit is een kutopdracht"));
        entryList.add(new JournalEntry(2, new Date(), "jevader", "aids", "dit is een tyfusopdracht"));
        entryList.add(new JournalEntry(3, new Date(), "jezuster", "lelijk", "dit is een hoerenopdracht"));


        // pass entryList to adapter
        EntryAdapter adapter = new EntryAdapter(this, 0, entryList);

        // set adapter
        listView.setAdapter(adapter);

        // set listener for listView
        listView.setOnItemClickListener(new ListItemClickListener());

        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
    }

    public void newEntry(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // make intent and include the instance of journalEntry
            JournalEntry journalEntry = (JournalEntry) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("entry", journalEntry);

            // start DetailActivity with intent
            startActivity(intent);
        }
    }
}
