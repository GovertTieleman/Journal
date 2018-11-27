package com.example.govert.journal;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {
    public EntryAdapter(@NonNull Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor);
    }

    // inflate and return new view
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.entry_row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // get views
        TextView dateTextView = (TextView) view.findViewById(R.id.dateTextView);
        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);

        // get properties
        String date = cursor.getString(cursor.getColumnIndex("date"));
        String title = cursor.getString(cursor.getColumnIndex("title"));

        // set views
        dateTextView.setText(date);
        titleTextView.setText(title);
    }
}
