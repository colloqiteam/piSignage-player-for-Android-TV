package com.pisignage.pisignageforandroidtv;

import android.graphics.Bitmap;
import android.webkit.WebChromeClient;

public class WebChromeClientCustomPoster extends WebChromeClient {
    @Override
    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    }
}