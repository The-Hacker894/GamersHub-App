package com.hackerlabs.sky.gamershub;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void goToSocialLinks (View v) {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            startActivity(new Intent(Home.this, Social.class));

            connected = true;
        }
        else

            Toast.makeText(this, "You need an Internet Connection for this!",
                    Toast.LENGTH_LONG).show();

        connected = false;


    }
    public void goToWebsite (View v) {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            startActivity(new Intent(Home.this, Website.class));

            connected = true;
        }
        else

            Toast.makeText(this, "You need an Internet Connection for this!",
                    Toast.LENGTH_LONG).show();

        connected = false;
    }
    public void goToEnglish (View v) {
        startActivity(new Intent(Home.this, EnglishHome.class));
    }

    public void goToDiscord (View view) {
        goToUrl ( "https://discord.io/frgamershub");
    }
    public void goToTwitter (View view) {
        goToUrl( "https://twitter.com/GamersHub1");
    }


    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
