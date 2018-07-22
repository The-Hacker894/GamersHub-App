package com.hackerlabs.sky.gamershub;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Credits extends AppCompatActivity {


    String hackerhub = "https://www.hacker-hub.com";
    String fontawesome = "https://fontawesome.com";
    String fontawesomelicense = "https://fontawesome.com/license";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        ab.setTitle("Credits");

        TextView creditText = (TextView)findViewById(R.id.creditText);
        TextView frenchText = (TextView)findViewById(R.id.frenchText);

        creditText.setText(R.string.credits);
        creditText.setMovementMethod(LinkMovementMethod.getInstance());



        frenchText.setText(R.string.credits_fr);
        frenchText.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
