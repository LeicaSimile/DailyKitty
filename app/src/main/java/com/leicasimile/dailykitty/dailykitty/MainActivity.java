package com.leicasimile.dailykitty.dailykitty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DownloadImageTask((ImageView)findViewById(R.id.main_imgKitty))
                .execute("https://c2.staticflickr.com/4/3134/2571204498_9b083a82ac_z.jpg?zz=1");
    }
}
