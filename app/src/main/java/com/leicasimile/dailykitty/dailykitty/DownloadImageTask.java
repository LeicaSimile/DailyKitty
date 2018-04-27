package com.leicasimile.dailykitty.dailykitty;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

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

// From https://stackoverflow.com/a/9288544
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private WeakReference<ImageView> bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = new WeakReference<ImageView>(bmImage);
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        final ImageView iv = bmImage.get();
        if (iv != null) {
            iv.setImageBitmap(result);
        }
    }
}
