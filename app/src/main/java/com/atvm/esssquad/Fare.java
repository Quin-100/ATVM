package com.atvm.esssquad;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Fare extends AppCompatActivity {

    String Id,Source,Destination,Adults,Childs,Section,Type,fare;
    int Fare = 0;
    TextView id,so,de,ad,ch,se,ty,fa,print;
    //ArrayList<String> temp = new ArrayList<>();
    //List<String> temp ;
    String[] temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        id = findViewById(R.id.Id);
        so = findViewById(R.id.so);
        de = findViewById(R.id.de);
        ad = findViewById(R.id.ad);
        ch = findViewById(R.id.ch);
        se = findViewById(R.id.se);
        ty = findViewById(R.id.ty);
        fa = findViewById(R.id.fa);
        print = findViewById(R.id.print);

        temp = getResources().getStringArray(R.array.stations);

        Id = getIntent().getStringExtra("Id");
        Source = getIntent().getStringExtra("So");
        Destination = getIntent().getStringExtra("De");
        Adults = getIntent().getStringExtra("Ad");
        Childs = getIntent().getStringExtra("Ch");
        Section = getIntent().getStringExtra("Se");
        Type = getIntent().getStringExtra("Ty");

        if (getIntent().getStringExtra("Show").equals("SavedTickets")){
            print.setVisibility(View.GONE);
            fare = getIntent().getStringExtra("Fa");
            if (fare.equals("Not Available")){
                Fare = 0;
            }
        }
        else {
            print.setVisibility(View.VISIBLE);
        }

        if(Type.equals("Single")){
            int index1 = Arrays.asList(temp).indexOf(Source);
            int index2 = Arrays.asList(temp).indexOf(Destination);
            if (Math.abs(index1-index2) <= 4){
                //Fare = 5
                if (Section.equals("I class")){
                    CalcFare(50,20);
                }
                else if (Section.equals("II class")){
                    CalcFare(5,2);
                }
            }
            else if (Math.abs(index1-index2) > 4 && Math.abs(index1-index2) <= 14){
                //Fare = 10;
                if (Section.equals("I class")){
                    CalcFare(80,30);
                }
                else if (Section.equals("II class")){
                    CalcFare(10,4);
                }
            }
            else if (Math.abs(index1-index2) > 14 && Math.abs(index1-index2) <= 29){
                //Fare = 15;
                if (Section.equals("I class")){
                    CalcFare(110,40);
                }
                else if (Section.equals("II class")){
                    CalcFare(15,6);
                }
            }
            else if (Math.abs(index1-index2) > 29 && Math.abs(index1-index2) <= 49){
                //Fare = 20;
                if (Section.equals("I class")){
                    CalcFare(150,50);
                }
                else if (Section.equals("II class")){
                    CalcFare(20,8);
                }
            }
            else if (Math.abs(index1-index2) > 49 && Math.abs(index1-index2) <= 74){
                //Fare = 25;
                if (Section.equals("I class")){
                    CalcFare(180,60);
                }
                else if (Section.equals("II class")){
                    CalcFare(25,10);
                }
            }
            else if (Math.abs(index1-index2) > 74 && Math.abs(index1-index2) <= 104){
                //Fare = 30;
                if (Section.equals("I class")){
                    CalcFare(210,70);
                }
                else if (Section.equals("II class")){
                    CalcFare(30,12);
                }
            }
            else if (Math.abs(index1-index2) > 104 && Math.abs(index1-index2) <= 139){
                //Fare = 35;
                if (Section.equals("I class")){
                    CalcFare(250,80);
                }
                else if (Section.equals("II class")){
                    CalcFare(35,14);
                }
            }
        }
        else if (Type.equals("Return")){
            int index1 = Arrays.asList(temp).indexOf(Source);
            int index2 = Arrays.asList(temp).indexOf(Destination);
            if (Math.abs(index1-index2) <= 4){
               // Fare = 10;
                if (Section.equals("I class")){
                    CalcFare(100,40);
                }
                else if (Section.equals("II class")){
                    CalcFare(10,4);
                }
            }
            else if (Math.abs(index1-index2) > 4 && Math.abs(index1-index2) <= 14){
               // Fare = 20;
                if (Section.equals("I class")){
                    CalcFare(160,60);
                }
                else if (Section.equals("II class")){
                    CalcFare(20,8);
                }
            }
            else if (Math.abs(index1-index2) > 14 && Math.abs(index1-index2) <= 29){
               // Fare = 30;
                if (Section.equals("I class")){
                    CalcFare(220,80);
                }
                else if (Section.equals("II class")){
                    CalcFare(30,12);
                }
            }
            else if (Math.abs(index1-index2) > 29 && Math.abs(index1-index2) <= 49){
               // Fare = 40;
                if (Section.equals("I class")){
                    CalcFare(300,100);
                }
                else if (Section.equals("II class")){
                    CalcFare(40,16);
                }
            }
            else if (Math.abs(index1-index2) > 49 && Math.abs(index1-index2) <= 74){
               // Fare = 50;
                if (Section.equals("I class")){
                    CalcFare(360,120);
                }
                else if (Section.equals("II class")){
                    CalcFare(50,20);
                }//116
            }
            else if (Math.abs(index1-index2) > 74 && Math.abs(index1-index2) <= 104){
                //Fare = 60;
                if (Section.equals("I class")){
                    CalcFare(420,140);
                }
                else if (Section.equals("II class")){
                    CalcFare(60,24);
                }
            }
            else if (Math.abs(index1-index2) > 104 && Math.abs(index1-index2) <= 139){
                //Fare = 70;
                if (Section.equals("I class")){
                    CalcFare(500,160);
                }
                else if (Section.equals("II class")){
                    CalcFare(70,28);
                }
            }
        }

        id.setText(Id);
        so.setText(Source);
        de.setText(Destination);
        ad.setText(Adults);
        ch.setText(Childs);
        se.setText(Section);
        ty.setText(Type);
        fa.setText(String.valueOf(Fare));

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = Fare.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                //Creating editor to store values to shared preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //Adding values to editor
                //editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, true);
                editor.putString(Config.ID_SHARED_PREF,id.getText().toString());
                editor.putString(Config.SO_SHARED_PREF,Source);
                editor.putString(Config.DE_SHARED_PREF,Destination);
                editor.putString(Config.AD_SHARED_PREF,Adults);
                editor.putString(Config.CH_SHARED_PREF,Childs);
                editor.putString(Config.SE_SHARED_PREF,Section);
                editor.putString(Config.TY_SHARED_PREF,Type);
                editor.putString(Config.FA_SHARED_PREF,fa.getText().toString());
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

    public void CalcFare(final int AFare, final int CFare){
        if (Adults.equals("0") || Childs.equals("0")){
            if (Adults.equals("0")){
                Fare = 0;
            }
            if (Childs.equals("0")){
                Fare = 0;
            }
        }
        if (Adults.equals("1") || Childs.equals("1")){
            if (Adults.equals("1")){
                Fare = Fare + AFare;
            }
            if (Childs.equals("1")){
                Fare = Fare + CFare;
            }
        }
        if (Adults.equals("2") || Childs.equals("2")){
            if (Adults.equals("2")){
                Fare = Fare + 2*AFare;
            }
            if (Childs.equals("2")){
                Fare = Fare + 2*CFare;
            }
        }
        if (Adults.equals("3") || Childs.equals("3")){
            if (Adults.equals("3")){
                Fare = Fare + 3*AFare;
            }
            if (Childs.equals("3")){
                Fare = Fare + 3*CFare;
            }
        }
        if (Adults.equals("4") || Childs.equals("4")){
            if (Adults.equals("4")){
                Fare = Fare + 4*AFare;
            }
            if (Childs.equals("4")){
                Fare = Fare + 4*CFare;
            }
        }
        if (Adults.equals("5") || Childs.equals("5")){
            if (Adults.equals("5")){
                Fare = Fare + 5*AFare;
            }
            if (Childs.equals("5")){
                Fare = Fare + 5*CFare;
            }
        }
    }
}
