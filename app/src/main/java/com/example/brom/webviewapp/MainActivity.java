package com.example.brom.webviewapp;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {
    // Create a private member variable that can hold our WebView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* This code is run when the App is created. Include code that creates your WebView */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        visaWebbSida("https://wwwlab.iit.his.se/a18eliek/WEBUGAppen/");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_omappen) {
            visaWebbSida("file:///android_asset/om-appen.html");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   public void visaWebbSida(String url) {
       WebView myWebView = (WebView) findViewById(R.id.webview);
       myWebView.loadUrl(url);

       //Slå på Javascript samt andra saker så att appen fungerar som det ska
       WebSettings webSettings = myWebView.getSettings();
       webSettings.setJavaScriptEnabled(true);
       webSettings.setDomStorageEnabled(true);
       myWebView.setWebChromeClient(new WebChromeClient());
       myWebView.setWebViewClient(new WebViewClient());
   }
}
