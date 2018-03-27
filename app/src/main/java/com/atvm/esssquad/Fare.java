package com.atvm.esssquad;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Fare extends AppCompatActivity {

    String Source,Destination,Adults,Childs,Section,Type,Fare;
    TextView so,de,ad,ch,se,ty,fa,print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        so = findViewById(R.id.so);
        de = findViewById(R.id.de);
        ad = findViewById(R.id.ad);
        ch = findViewById(R.id.ch);
        se = findViewById(R.id.se);
        ty = findViewById(R.id.ty);
        fa = findViewById(R.id.fa);
        print = findViewById(R.id.print);

        Source = getIntent().getStringExtra("So");
        Destination = getIntent().getStringExtra("De");
        Adults = getIntent().getStringExtra("Ad");
        Childs = getIntent().getStringExtra("Ch");
        Section = getIntent().getStringExtra("Se");
        Type = getIntent().getStringExtra("Ty");
        Fare = "10";

        if (getIntent().getStringExtra("Show").equals("SavedTickets")){
            print.setVisibility(View.GONE);
            Fare = getIntent().getStringExtra("Fa");
        }
        else {
            print.setVisibility(View.VISIBLE);
        }


        so.setText(Source);
        de.setText(Destination);
        ad.setText(Adults);
        ch.setText(Childs);
        se.setText(Section);
        ty.setText(Type);
        fa.setText(Fare );

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = Fare.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                //Creating editor to store values to shared preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //Adding values to editor
                //editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, true);
                editor.putString(Config.SO_SHARED_PREF,Source);
                editor.putString(Config.DE_SHARED_PREF,Destination);
                editor.putString(Config.AD_SHARED_PREF,Adults);
                editor.putString(Config.CH_SHARED_PREF,Childs);
                editor.putString(Config.SE_SHARED_PREF,Section);
                editor.putString(Config.TY_SHARED_PREF,Type);
                editor.putString(Config.FA_SHARED_PREF,Fare);
                //Saving values to editor
                editor.commit();

                AlertDialog.Builder builder = new AlertDialog.Builder(Fare.this);
                builder.setMessage("Your ticket has been saved. check in saved tickets menu")
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent in = new Intent(Fare.this,MainActivity.class);
                                startActivity(in);
                                finish();
                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent i = new Intent(Fare.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
