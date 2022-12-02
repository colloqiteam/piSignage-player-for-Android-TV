package com.pisignage.pisignageforandroidtv;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.WindowManager;

import android.util.Log;
//import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkOverlayPermission();
        //  Toast.makeText(getApplicationContext(), "Notifying on Create event", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        WebView webView = (WebView) findViewById(R.id.main_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false); // to enable audio in video/audio files without requiring User gesture
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // to disable ambient mode in android TV - ambient mode shows up when static content is displayed like iframes/images
        webView.setWebViewClient(new WebViewClient());

        // https://stackoverflow.com/questions/18271991/html5-video-remove-overlay-play-icon
        webView.setWebChromeClient(new WebChromeClientCustomPoster()); // to hide PLAY button before playing videos

        webView.loadUrl("https://pisignage.com/player2/index.html");
        // Toast.makeText(getApplicationContext(), "Notifying On resume event", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        WebView webView = (WebView) findViewById(R.id.main_webview);
        webView.setWebChromeClient(new WebChromeClientCustomPoster()); // to hide PLAY button before playing videos
        // Toast.makeText(getApplicationContext(), "Notifying On start event", Toast.LENGTH_LONG).show();
    }

    //https://www.geeksforgeeks.org/how-to-draw-over-other-apps-in-android/
    public void checkOverlayPermission() {
        try {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(!Settings.canDrawOverlays((this))){
                    // Toast.makeText(getApplicationContext(), "[startSystemAlertWindowPermission] requesting system alert window permission.", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                    startActivity(myIntent);
                }
            }
        } catch (Exception e){
            //  Toast.makeText(getApplicationContext(), "[startSystemAlertWindowPermission] error.", Toast.LENGTH_LONG).show();
            Log.e(TAG, "[startSystemAlertWindowPermission] error:", e);
        }
    }

}