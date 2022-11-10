package com.pisignage.pisignageforandroidtv;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        WebView webView = (WebView) findViewById(R.id.main_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        // https://stackoverflow.com/questions/18271991/html5-video-remove-overlay-play-icon
        webView.setWebChromeClient(new WebChromeClientCustomPoster()); // to hide PLAY button before playing videos

        webView.loadUrl("https://pisignage.com/player2/index.html");
    }

    @Override
    protected void onStart() {
        super.onStart();
        WebView webView = (WebView) findViewById(R.id.main_webview);
        webView.setWebChromeClient(new WebChromeClientCustomPoster()); // to hide PLAY button before playing videos
    }
}
