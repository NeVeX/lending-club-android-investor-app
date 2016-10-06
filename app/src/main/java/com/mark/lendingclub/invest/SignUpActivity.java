package com.mark.lendingclub.invest;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

public class SignUpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final WebView webView = (WebView) findViewById(R.id.prosper_sign_up_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.lendingclub.com/lender/registerNow.action");

        ActionBar ab = this.getActionBar();
        if ( ab != null)
        {
            ab.setTitle("Sign up online");
            ab.setHomeButtonEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
