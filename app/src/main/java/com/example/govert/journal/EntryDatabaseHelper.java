package com.example.govert.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EntryDatabaseHelper extends SQLiteOpenHelper {
    // declare DB_NAME and TABLE_NAME
    private static final String DB_NAME = "journal.db";
    private static final String TABLE_NAME = "journal_entries";

    // declare CREATE_TABLE_SQL query
    private static final String CREATE_TABLE_SQL = "CREATE TABLE journal_entries (_id " +
            "INTEGER PRIMARY KEY AUTOINCREMENT,date TEXT,title TEXT," +
            "mood TEXT,entry TEXT)";

    // create static instance of EntryDatabase
    private static EntryDatabaseHelper instance;

    private EntryDatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop old table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // recreate table
        onCreate(db);
    }

    public static EntryDatabaseHelper getInstance(Context context) {
        // if instance exists, return it
        if (instance != null)
            return instance;

        // if instance doesn't exist, created it and return it
        instance = new EntryDatabaseHelper(context);
        return instance;
    }

    public Cursor selectALL() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT _id, date, title, mood, entry FROM journal_entries", null);
    }

    public void insert(JournalEntry entry) {
        // get db
        SQLiteDatabase db = this.getWritableDatabase();

        // declare values
        ContentValues values = new ContentValues();

        // put values
        values.put("date", entry.getDate());
        values.put("title", entry.getTitle());
        values.put("mood", entry.getMood());
        values.put("entry", entry.getEntry());

        // insert entry into db
        db.insert(TABLE_NAME, null, values);
    }

    public void delete(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String SQLDeleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE _id=" + id;

        db.execSQL(SQLDeleteQuery);
    }
}
