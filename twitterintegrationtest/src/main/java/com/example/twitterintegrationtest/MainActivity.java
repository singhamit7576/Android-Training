package com.example.twitterintegrationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {
    TwitterLoginButton btn_login_button;

    private static final String TWITTER_KEY = "o31ZzbLRALwz6OjCoQKFOGadz";
    private static final String TWITTER_SECRET = " ByfBWEhsb63oB8QZgHPur2W7pI8I4ZkP4pS2sjIRRSINKZgNk0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.TwitterAuthConfigSetup();
        setContentView(R.layout.activity_main);
        this.setReference();
        this.CallbackSetup();

    }


    private void TwitterAuthConfigSetup() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }


    private void setReference() {
        btn_login_button         =      (TwitterLoginButton) findViewById(R.id.btn_login_button);
    }


    private void CallbackSetup() {

        btn_login_button.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {

                TweetComposer.Builder builder = new TweetComposer.Builder(MainActivity.this).text("Hello");
                builder.show();
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        btn_login_button.onActivityResult(requestCode, resultCode, data);
    }


}
