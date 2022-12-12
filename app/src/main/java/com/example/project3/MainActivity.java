package com.example.project3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView calculator, playmusic, batterylife;
    ImageButton texttospeech;
    TextView textviewspeech;

    private DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    Fragment fragment;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    private static final int requestCodeKey = 1000;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = (ImageView) findViewById(R.id.calculator);
        playmusic = (ImageView) findViewById(R.id.playmusic);
        batterylife = (ImageView) findViewById(R.id.batterylife);
        texttospeech = (ImageButton) findViewById(R.id.texttospeech);
        textviewspeech = (TextView) findViewById(R.id.textviewspeech);

        drawerLayout=(DrawerLayout) findViewById(R.id.drawer);
        toolbar=(Toolbar) findViewById(R.id.toolbarcustomized);
        navigationView=(NavigationView) findViewById(R.id.navigationView);

        //setSupportActionBar(toolbar);

        actionBarDrawerToggle=new ActionBarDrawerToggle
                (this, drawerLayout, toolbar,
                        R.string.navigation_open, R.string.navigation_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle.syncState();
        getSupportFragmentManager().beginTransaction().
                replace(R.id.container, new HomeFragment()).commit();

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(i);
            }
        });

        playmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(i);
            }
        });

        batterylife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BatteryActivity.class);
                startActivity(i);
            }
        });

        /*texttospeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });*/
    }

    public void speak(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hello, please speak something...");

        try {
            startActivityForResult(intent, requestCodeKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case requestCodeKey: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textviewspeech.setText(result.get(0));
                }
                break;
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homelayout:
                fragment = new HomeFragment();
                break;
            case R.id.tablayouts:
                fragment = new TablayoutsFragment();
                break;
            case R.id.viewsliders:
                fragment = new ViewslidersFragment();
                break;
        }

        getSupportFragmentManager().beginTransaction().
                replace(R.id.container, fragment).commit();

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}