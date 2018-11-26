package com.example.govert.journal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class EntryDatabase extends SQLiteOpenHelper {

    private static final String CREATE_TABLE_SQL = "CREATE TABLE journal_entries (id " +
            "INTEGER PRIMARY KEY AUTOINCREMENT, date DATETIME, title TEXT," +
            " mood TEXT, entry TEXT)";

    private static final String DB_NAME = "journal_entries";

    private static final int DB_VERSION = 1;

    private static EntryDatabase instance;

    public EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    // create database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);

        SQLiteStatement stmt = db.compileStatement("INSERT INTO journal_entries (title, mood, entry) VALUES(?,?,?)");

        stmt.bindString(1, "trol");
        stmt.bindString(2, "kut");
        stmt.bindString(3, "doe normaal gap");
        stmt.execute();
        stmt.close();
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == oldVersion + 1) {
            // drop old table
            db.execSQL("DROP TABLE " + DB_NAME);

            // recreate table
            onCreate(db);
        }
    }

    private static EntryDatabase getInstance(Context context) {
        try {
            return instance;
        }
        catch (Exception e){
            instance = new EntryDatabase(context, DB_NAME, null, DB_VERSION);
            return instance;
        }
    }
}
