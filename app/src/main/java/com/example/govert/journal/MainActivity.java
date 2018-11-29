package com.example.govert.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    private EntryDatabaseHelper db;
    private EntryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get listView
        ListView listView = (ListView) findViewById(R.id.entryList);

        // get database
        db = EntryDatabaseHelper.getInstance(this);

        // get cursor
        Cursor cursor = db.selectALL();

        // get adapter
        adapter = new EntryAdapter(this, cursor);

        // set adapter
        listView.setAdapter(adapter);

        // set listeners
        listView.setOnItemClickListener(new ListItemClickListener());
        listView.setOnItemLongClickListener(new ListItemLongClickListener());
    }

    public void newEntry(View view) {
        startActivity(new Intent(MainActivity.this, InputActivity.class));
    }

    private void updateData() {
        // update cursor
        adapter.swapCursor(db.selectALL());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // get cursor
            Cursor clickedEntryCursor = (Cursor) parent.getItemAtPosition(position);

            // get properties
            Integer _id = clickedEntryCursor.getInt(clickedEntryCursor.getColumnIndex("_id"));
            String date = clickedEntryCursor.getString(clickedEntryCursor.getColumnIndex("date"));
            String title = clickedEntryCursor.getString(clickedEntryCursor.getColumnIndex("title"));
            String mood = clickedEntryCursor.getString(clickedEntryCursor.getColumnIndex("mood"));
            String entry = clickedEntryCursor.getString(clickedEntryCursor.getColumnIndex("entry"));

            // create JournalEntry instance
            JournalEntry clickedEntry = new JournalEntry(_id, date, title, mood, entry);

            // make intent
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("clickedEntry", clickedEntry);

            // start DetailActivity with intent
            startActivity(intent);
        }
    }

    private class ListItemLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            // get cursor
            Cursor clickedEntryCursor = (Cursor) parent.getItemAtPosition(position);

            // delete entry
            db.delete(clickedEntryCursor.getInt(clickedEntryCursor.getColumnIndex("_id")));

            // update interface
            updateData();
            return true;
        }
    }
}
