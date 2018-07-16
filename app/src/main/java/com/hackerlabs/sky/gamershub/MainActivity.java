package com.hackerlabs.sky.gamershub;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String discordInv = "https://discord.gg/rJMDvKH";
    String twitterLnk = "https://twitter.com/GamersHub1/";
    String youtubeLnk = "https://www.youtube.com/channel/UCzLUBprrfh_CISVY1pb-4GA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView descText = (TextView) findViewById(R.id.descText);
        TextView titleText = (TextView) findViewById(R.id.titleText);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        descText.setText(R.string.desc_fr);



        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        assert getSupportActionBar() != null;

        if(getSupportActionBar() != null) {
            ab.setIcon(R.mipmap.icon_launcher);
            ab.setTitle("");
        }



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        ActionBar ab = getSupportActionBar();

        int id = item.getItemId();

        if (id == R.id.french_home) {
            // Load French Home
            TextView descText = (TextView)findViewById(R.id.descText);

            descText.setText(R.string.desc_fr);
        } else if (id == R.id.english_home) {
            //Load English Home

            TextView descText = (TextView)findViewById(R.id.descText);

            descText.setText(R.string.desc);


        } else if (id == R.id.website_view) {
            //Load Website View

            boolean connected = false;
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                startActivity(new Intent(this, Website.class));
                connected = true;
            }
            else

                Toast.makeText(this, Html.fromHtml("You need an internet connection for this! <br>Vous avez besoin d'une connexion Internet pour cela!"),
                        Toast.LENGTH_LONG).show();

            connected = false;


        } else if (id == R.id.discord) {
            //Open Discord Link

            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(discordInv));
            startActivity(i);
        } else if (id == R.id.twitter) {
            //Open Twitter Link
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterLnk));
            startActivity(i);
        } else if (id == R.id.youtube) {
            //Open YouTube Link
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeLnk));
            startActivity(i);

        } else if (id == R.id.credits) {
            //Open Credits
            startActivity(new Intent(this, Credits.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
