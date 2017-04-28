package com.myapp.ui.ImplicitDemo;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.user.myapp.R;
import com.myapp.ui.Widgets.Webvieww;

/**
 * Create Activity
 * which extends The AppCompact
 */
public class MYbrowserActivity extends AppCompatActivity {

    private WebView webview =   null;
    private String url  =   "https://www.google.com";


    /**
     * use web View ,In which
     * our given url will load.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybrowser);
        // TextView txt = (TextView) findViewById(R.id.txt_browser);
        // Uri url = getIntent().getData();
        //txt.setText(url.toString());

        webview     =    (WebView) findViewById(R.id.webView1);

        webview.loadUrl(url);

    }
    }
