package com.example.facbookintegration.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.facbookintegration.BaseActivity.BaseClass;
import com.example.facbookintegration.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * create Activity which extends another Activity which
 * have Some Abstract Method.
 */

public class LoginActivityTest extends BaseClass implements View.OnClickListener {

   // private TextView tv_info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private Button btn_details,btn_share,btn_delete_post;
    private ShareDialog shareDialog ;
    private ProfilePictureView profilePictureView;
    private Dialog details_dialog;
    private TextView details_txt;
    private AccessToken   accessToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.intializeFacebookSdk();
        setContentView(R.layout.activity_login_activity_test);

        this.setReference();
        this.onListener();
    }

    private void intializeFacebookSdk() {

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager     =   CallbackManager.Factory.create();
        shareDialog         =   new ShareDialog(this);

    }

    @Override
    protected void setReference() {

       // tv_info                 =   (TextView)           findViewById(R.id.tv_info);
        loginButton             =   (LoginButton)        findViewById(R.id.login_button);
        profilePictureView      =   (ProfilePictureView) findViewById(R.id.picture);
        btn_details             =   (Button)             findViewById(R.id.btn_details);
        btn_share               =   (Button)             findViewById(R.id.btn_share);
        btn_delete_post         =   (Button)             findViewById(R.id.btn_delete_post);
        btn_share.setVisibility(View.INVISIBLE);
        btn_details.setVisibility(View.INVISIBLE);
        btn_delete_post.setVisibility(View.INVISIBLE);
        //loginButton.setPublishPermissions( "publish_actions, user_photos, read_stream");
        this.dialogSetup();
    }

    private void dialogSetup() {

        details_dialog      =   new Dialog(this);
        details_dialog.setContentView(R.layout.dailog_details);
        details_dialog.setTitle("Details");
        details_txt         = (TextView)details_dialog.findViewById(R.id.details);

    }

    @Override
    protected void onListener() {
        btn_details.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        btn_delete_post.setOnClickListener(this);
        this.registerCallbackSetup();
    }



    private void registerCallbackSetup() {
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                accessToken = AccessToken.getCurrentAccessToken();
                if(accessToken != null){
                    RequestData();
                    btn_share.setVisibility(View.VISIBLE);
                    btn_details.setVisibility(View.VISIBLE);
                    btn_delete_post.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onCancel() {
                //tv_info.setText("Login attempt canceled.");
            }
            @Override
            public void onError(FacebookException error) {


               // tv_info.setText("Login attempt failed.");
            }
        });
    }

    private void RequestData() {

        GraphRequest request =  GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        JSONObject jsonObject = response.getJSONObject();
                        try {
                            if(jsonObject != null){
                                String text = "Name : "+jsonObject.getString("name")
                                        +"\n"+"Email : "+jsonObject.getString("email")
                                        +"\n"+"Profile link :  "+jsonObject.getString("link");
                                details_txt.setText(text);
                                profilePictureView.setProfileId(jsonObject.getString("id"));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,link,email,picture");
        request.setParameters(bundle);
        request.executeAsync();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_details:
                this.userDetails();
                break;

            case R.id.login_button:
                this.loginSetup();
                break;

            case R.id.btn_share:
                this.sharingSetUp();
                break;

            case R.id.btn_delete_post:
                this.deletePost();
        }
    }

    private void deletePost() {
        if(AccessToken.getCurrentAccessToken() != null){
            RequestDataDelete();
            btn_delete_post.setVisibility(View.VISIBLE);
            btn_share.setVisibility(View.VISIBLE);
            btn_details.setVisibility(View.VISIBLE);
        }



    }

    private void RequestDataDelete() {


        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/{post-id}",
                null,
                HttpMethod.DELETE,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        Toast.makeText(LoginActivityTest.this, "deleted", Toast.LENGTH_SHORT).show();
            /* handle the result */
                    }
                }
        ).executeAsync();
    }


    private void sharingSetUp() {
        Bitmap bitmap             = BitmapFactory.decodeResource(getResources(), R.drawable.bagpiper);
        SharePhoto photo          = new SharePhoto.Builder().setBitmap(bitmap).build();
        SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();
        LoginManager.getInstance().logInWithPublishPermissions(LoginActivityTest.this, Arrays.asList("publish_actions"));
        shareDialog.show(content);

    }

    private void loginSetup() {
        if(AccessToken.getCurrentAccessToken() != null) {
            btn_share.setVisibility(View.INVISIBLE);
            btn_details.setVisibility(View.INVISIBLE);
            btn_delete_post.setVisibility(View.INVISIBLE);
            profilePictureView.setProfileId(null);
        }
    }

    private void userDetails() {
        details_dialog.show();
        if(AccessToken.getCurrentAccessToken() != null){
            RequestData();
            btn_share.setVisibility(View.VISIBLE);
            btn_details.setVisibility(View.VISIBLE);
        }


    }
}
