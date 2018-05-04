package com.atvm.esssquad;

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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    Spinner source,destination,adults,childs,section,type;
    TextView go;
    String id;
    String[] Stations,Adults,Childs,Section,Type,Temp;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        source = findViewById(R.id.source);
        destination = findViewById(R.id.destination);
        adults = findViewById(R.id.adults);
        childs = findViewById(R.id.childs);
        section = findViewById(R.id.section);
        type = findViewById(R.id.type);
        go = findViewById(R.id.go);

        RandomString randomString = new RandomString(8, ThreadLocalRandom.current());
        id = randomString.nextString();

        Temp = getResources().getStringArray(R.array.stations);
        Stations = getResources().getStringArray(R.array.stations);
        Arrays.sort(Stations);
        Adults = getResources().getStringArray(R.array.adults);
        Childs = getResources().getStringArray(R.array.childs);
        Section = getResources().getStringArray(R.array.section);
        Type = getResources().getStringArray(R.array.type);

        populateSpinner1();
        populateSpinner2();
        populateSpinner3();
        populateSpinner4();
        populateSpinner5();
        populateSpinner6();

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(source.getSelectedItem().equals(destination.getSelectedItem()) || (adults.getSelectedItem().equals("0") && childs.getSelectedItem().equals("0"))){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Please insert proper entries.")
                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setCancelable(false)
                            .create()
                            .show();
                }
                else {
                    Intent i = new Intent(MainActivity.this,Fare.class);
                    i.putExtra("Id",id);
                    i.putExtra("So",(String) source.getSelectedItem());
                    i.putExtra("De",(String) destination.getSelectedItem());
                    i.putExtra("Ad",(String) adults.getSelectedItem());
                    i.putExtra("Ch",(String) childs.getSelectedItem());
                    i.putExtra("Se",(String) section.getSelectedItem());
                    i.putExtra("Ty",(String) type.getSelectedItem());
                    i.putExtra("Fa","");
                    i.putExtra("Show","Ticket");
                    startActivity(i);
                    finish();
                }

            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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
        if (id == R.id.action_settings) {
            final SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
            //Fetching the boolean value form sharedpreferences
            String ticid = sharedPreferences.getString(Config.ID_SHARED_PREF, "Not Available");
            String so = sharedPreferences.getString(Config.SO_SHARED_PREF, "Not Available");
            String de = sharedPreferences.getString(Config.DE_SHARED_PREF, "Not Available");
            String ad = sharedPreferences.getString(Config.AD_SHARED_PREF, "Not Available");
            String ch = sharedPreferences.getString(Config.CH_SHARED_PREF, "Not Available");
            String se = sharedPreferences.getString(Config.SE_SHARED_PREF, "Not Available");
            String ty = sharedPreferences.getString(Config.TY_SHARED_PREF, "Not Available");
            String fa = sharedPreferences.getString(Config.FA_SHARED_PREF, "Not Available");

            Intent i = new Intent(MainActivity.this,Fare.class);
            i.putExtra("Id",ticid);
            i.putExtra("So",so);
            i.putExtra("De",de);
            i.putExtra("Ad",ad);
            i.putExtra("Ch",ch);
            i.putExtra("Se",se);
            i.putExtra("Ty",ty);
            i.putExtra("Fa",fa);
            i.putExtra("Show","SavedTickets");
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void populateSpinner1() {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, Stations);
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        source.setAdapter(spinnerAdapter);
        source.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                source.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void populateSpinner2() {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, Stations);
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destination.setAdapter(spinnerAdapter);
        destination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                destination.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void populateSpinner3() {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, Adults);
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adults.setAdapter(spinnerAdapter);
        adults.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adults.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void populateSpinner4() {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, Childs);
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        childs.setAdapter(spinnerAdapter);
        childs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                childs.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void populateSpinner5() {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, Section);
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        section.setAdapter(spinnerAdapter);
        section.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                section.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void populateSpinner6() {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, Type);
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(spinnerAdapter);
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
