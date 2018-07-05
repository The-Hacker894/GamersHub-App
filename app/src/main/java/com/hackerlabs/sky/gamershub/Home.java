package com.hackerlabs.sky.gamershub;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    private static final String TAG = "MainActivity";

            private ImageView Discord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Discord = (ImageView) findViewById(R.id.DiscordButton);

        Discord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog(R.string.discord_server_fr, R.string.discord_server_question_fr, "GamersHub Renaissance", "GamersHub");

            }
        });
    }

    /**
     * Alert Dialog
     * @param title
     * @param message
     * @param cancelMethod
     * @param okMethod

     */
    public void customDialog(int title, int message, final String cancelMethod, final String okMethod) {
        final android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(this);
        builderSingle.setIcon(R.drawable.ic_dns_black_24dp);
        builderSingle.setTitle(title);
        builderSingle.setMessage(message);

        builderSingle.setNegativeButton(
                "GamersHub",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(cancelMethod.equals("cancelMethod1")) {
                            goToUrl ( "https://discord.gg/RkZ62QH");
                        } else {
                            goToUrl("https://discord.gg/Ak52Axg");

                        }
                    }
                });
        builderSingle.setPositiveButton(
                "GamersHub Renaissance",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(okMethod.equals("okMethod1")) {
                            goToUrl("https://discord.gg/Ak52Axg");
                        } else {
                            goToUrl ( "https://discord.gg/RkZ62QH");

                        }
                    }

                    });
        builderSingle.show();
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

            Toast.makeText(this, R.string.internet_error_fr,
                    Toast.LENGTH_LONG).show();

        connected = false;
    }
    public void goToEnglish (View v) {
        startActivity(new Intent(Home.this, EnglishHome.class));
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
