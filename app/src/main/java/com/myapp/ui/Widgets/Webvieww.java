package com.myapp.ui.Widgets;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;


/**
 * create WebView
 * which extends Base Class which have some abstract
 * method.
 */

public class Webvieww extends BaseActivity {

    private WebView webview;
    private ProgressBar progressbar;
    private String url  =   "https://developer.android.com/guide/topics/media-apps/media-apps-overview.html";

    /**
     * Activity Created.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        this.setReference();
        this.OnListener();
}


    /**
     * Set Reference of
     * Web View and Progress Bar.
     */
    @Override
    protected void setReference() {
        webview             =            (WebView)  findViewById(R.id.webview);
        progressbar         =            (ProgressBar)  findViewById(R.id.progress);

    }

    @Override
    protected void OnListener() {
        onload();

    }

    private void onload() {
            webview.setWebViewClient(new MyView());
            webview.loadUrl(url);
    }


    /**
     * create class MyView
     * which extends WebView Client which gives
     *  Give the host application a chance to take over the control when a new
     * url is about to be loaded in the current WebView.
     */
    public class MyView extends WebViewClient{


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            super.onPageStarted(view, url, favicon);
            progressbar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressbar.setVisibility(View.GONE);
        }
    }

    /**
     * used for bcak pressed.
     */
    public void onBackPressed() {

        if(webview.canGoBack()){
            webview.goBack();
            return ;
        }
        super.onBackPressed();
    }

}






