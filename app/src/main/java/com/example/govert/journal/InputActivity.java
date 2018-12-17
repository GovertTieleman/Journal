package com.example.govert.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InputActivity extends AppCompatActivity {
    private String ImgId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        // get radioButtons
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);

        // set listener
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener());
    }

    public void submitEntry(View view) {
        // get entryDate
        Format formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date = Calendar.getInstance().getTime();
        String entryDate = formatter.format(date);

        // get title and entry from views
        EditText titleEditText = findViewById(R.id.titleEditText);
        String titleText = titleEditText.getText().toString();

        EditText entryEditText = findViewById(R.id.entryEditText);
        String entryText = entryEditText.getText().toString();

        // create entry object
        JournalEntry entry = new JournalEntry(null, entryDate, titleText, ImgId, entryText);

        // get db
        EntryDatabaseHelper db = EntryDatabaseHelper.getInstance(this.getApplicationContext());

        // insert into db
        db.insert(entry);

        // go back to MainActivity
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    private class OnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.radioButton1:
                    ImgId = "happier";
                    break;
                case R.id.radioButton2:
                    ImgId = "happy";
                    break;
                case R.id.radioButton3:
                    ImgId = "sad";
                    break;
                case R.id.radioButton4:
                    ImgId = "sadder";
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
