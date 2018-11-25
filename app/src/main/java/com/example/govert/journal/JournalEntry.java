package com.example.govert.journal;

import java.io.Serializable;
import java.util.Date;

public class JournalEntry implements Serializable {

    private Date date;
    private String title;
    private String mood;
    private String entry;

    // constructor to create instance of JournalEntry
    public JournalEntry(Date date, String title, String mood, String entry) {
        this.date = date;
        this.title = title;
        this.mood = mood;
        this.entry = entry;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getMood() {
        return mood;
    }

    public String getEntry() {
        return entry;
    }
}
