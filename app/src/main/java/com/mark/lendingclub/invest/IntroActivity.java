package com.mark.lendingclub.invest;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mark.lendingclub.invest.config.Configuration;
import com.mark.lendingclub.invest.constant.ApplicationConstants;

import com.mark.lendingclub.invest.R;

public class IntroActivity extends Activity {

    private static final String TAG = ApplicationConstants.LOG_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Configuration.initialize(this);

        ActionBar ab = this.getActionBar();
        if ( ab != null)
        {
            ab.hide();
        }

        doTesting();
    }

    private void doTesting()
    {

    }

    public void onSignInButtonClick(View view)
    {
        Log.d(TAG, "Sign in button clicked");
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    public void onSignUpButtonClick(View view)
    {
        Log.d(TAG, "Sign up button clicked");
        Intent signUpIntent = new Intent(this, SignUpActivity.class);
        startActivity(signUpIntent);
    }
}
