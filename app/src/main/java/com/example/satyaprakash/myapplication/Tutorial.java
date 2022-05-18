package com.example.satyaprakash.myapplication;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.webkit.WebView;

/**
 * Created by Satya Prakash on 30-01-2018.
 */

public class Tutorial extends AppCompatActivity {

    AppBarLayout appBarLayout;
    Toolbar toolbar;
    WebView webView;
    String sss;
    CharSequence str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);


        toolbar = (Toolbar) findViewById(R.id.toolbar3);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar1);
        webView = (WebView) findViewById(R.id.web_tut);
        this.webView.getSettings().setBuiltInZoomControls(false);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setUseWideViewPort(true);

        toolbar.setNavigationIcon(R.drawable.ic_action_name);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            toolbar.setTitle(bundle.getString("tutoriallist"));

            str = bundle.getString("tutoriallist").toLowerCase();
            sss = "file:///android_asset/tut/" + str + ".html";

            this.webView.loadUrl(sss);
        }

    }
}
