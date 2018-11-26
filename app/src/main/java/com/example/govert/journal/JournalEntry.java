package com.example.govert.journal;

import java.io.Serializable;
import java.util.Date;

public class JournalEntry implements Serializable {

    private Integer id;
    private Date date;
    private String title;
    private String mood;
    private String entry;

    // constructor to create instance of JournalEntry
    public JournalEntry(Integer id, Date date, String title, String mood, String entry) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
