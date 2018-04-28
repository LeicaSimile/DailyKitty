package com.leicasimile.dailykitty.dailykitty;

import android.app.IntentService;
import android.content.Intent;
import android.widget.ImageView;

public class DownloadImageService extends IntentService {
    private Thread thread = new Thread();

    public DownloadImageService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        thread.start();
        ImageView bmImage = (ImageView)intent.getExtras().get("imageview");
        String url = intent.getExtras().getString("url");

        new DownloadImageTask(bmImage).execute(url);
    }
}