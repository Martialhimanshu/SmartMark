package com.Teacher_MSIT.teacherassistant.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.Teacher_MSIT.teacherassistant.MSIT_website;
import com.Teacher_MSIT.teacherassistant.R;

public class MapsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        WebView webView =(WebView)findViewById(R.id.maps);
        webView.setWebViewClient(new MyBrowser());


        webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("https://www.google.co.in/maps/place/Maharaja+Surajmal+Group+of+Institutions/" +
                "@28.6213012,77.0896291,17z/data=!3m1!4b1!4m5!3m4!1s0x390d04afb8dbcfe1" +
                ":0xaff19e718be2136b!8m2!3d28.6213012!4d77.0918178");

    }



    private class MyBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}




