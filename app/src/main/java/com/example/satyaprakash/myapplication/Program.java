package com.example.satyaprakash.myapplication;

import android.graphics.BitmapFactory;

import com.google.android.material.appbar.AppBarLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import android.webkit.WebView;
import android.widget.ImageView;

public class Program extends AppCompatActivity {

    AppBarLayout appBarLayout;
    Toolbar toolbar;
    WebView webView;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program);

        toolbar = findViewById(R.id.toolbar_prog);
        appBarLayout = findViewById(R.id.appbar_prog);
        webView = findViewById(R.id.web_prog);
        imageView = findViewById(R.id.img_op);
        this.webView.getSettings().setBuiltInZoomControls(false);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setUseWideViewPort(true);

        toolbar.setNavigationIcon(R.drawable.ic_action_name);

        toolbar.setNavigationOnClickListener(view -> finish());

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            toolbar.setTitle(bundle.getString("program_list"));

            CharSequence str = bundle.getString("program_list").toLowerCase();
            String s = "prog/" + str + ".png";
            String ss = "file:///android_asset/prog/" + str + ".html";

            //if (toolbar.getTitle().toString().equalsIgnoreCase("Linear Search")){

            this.webView.loadUrl(ss);

            try {
                imageView.setImageBitmap(BitmapFactory.decodeStream(getAssets().open(s)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
