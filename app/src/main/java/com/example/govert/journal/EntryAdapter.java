package com.example.govert.journal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EntryAdapter extends ArrayAdapter<JournalEntry> {
    // initialize context and entryList
    private List<JournalEntry> entryList;

    public EntryAdapter(@NonNull Context context, int resource, List<JournalEntry> list) {
        super(context, resource, list);

        // set context and entryList
        entryList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get listItem
        View listItem = convertView;

        // inflate listItem if null
        if(listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.entry_row, parent,false);

        // get JournalEntry
        JournalEntry currentEntry = entryList.get(position);

        // set date
        TextView dateView = (TextView) listItem.findViewById(R.id.dateTextView);
        Date date = currentEntry.getDate();
        DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
        String dateString = dateFormat.format(date);
        dateView.setText(dateString);

        // set title
        TextView titleView = (TextView) listItem.findViewById(R.id.titleTextView);
        titleView.setText(currentEntry.getTitle());

        return listItem;
    }
}
