package com.geekbrains.weather;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";
    private static final String TEXT = "TEXT";
    private static final String TEXTCITY = "TEXTCITY";

    private TextView textView;
    private TextView textViewCity;
    private FloatingActionButton fab;
    private Boolean isPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_main);
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск";
        } else {
            instanceState = "Повторный запуск";
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Toasty.success(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();

        textView = findViewById(R.id.tv);
        textViewCity = findViewById(R.id.tvcity);

        fab = findViewById(R.id.fab);

        if (getIntent().getExtras() != null && getIntent().getExtras().getString(TEXT)!= null ) {
            String text = getIntent().getExtras().getString(TEXT);
            textView.setText("Добрый день, " + text);
        } else textView.setText("Добрый день");


        if(getIntent().getExtras().getString(TEXTCITY) != null && !getIntent().getExtras().getString(TEXTCITY).isEmpty()){
            String textcity = getIntent().getExtras().getString(TEXTCITY);
            textViewCity.setText(textcity);
        } else


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPressed) {
                    isPressed = true;
                    startNewActivity(CreateActionActivity.class);
                }
            }
        });

        Log.d(TAG, "onCreate");
    }

    private void startNewActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isPressed = false;
        startNewActivity(StartActivity.class);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("savedCity",textViewCity.getText());
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textViewCity.setText(savedInstanceState.getCharSequence("savedCity"));
        Log.d(TAG, "onRestoreInstanceState");

    }
}
