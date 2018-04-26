package com.leicasimile.dailykitty.dailykitty;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        try {
            db.updateDatabase();
        } catch (IOException mIOException) {
            throw new Error("Unable to update database");
        }

        displayRandomKitty();
    }

    private void displayRandomKitty() {
        String randomUrl = db.getRandomUrl();
        new DownloadImageTask((ImageView)findViewById(R.id.main_imgKitty))
                .execute(randomUrl);
    }
}
