package com.geekbrains.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {
    private static final String TEXTCITY = "TEXTCITY";
    private EditText editTextCity;
    private FloatingActionButton fab;
    private Boolean isPressed = false;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        editTextCity = findViewById(R.id.et);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPressed) {
                    isPressed = true;
                    startNewActivity();
                    finish();
                }
            }
        });


        }
    private void startNewActivity() {
        Intent intent = new Intent(this, WeatherActivity.class);
        intent.putExtra(TEXTCITY, editTextCity.getText().toString().trim());
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isPressed = false;

    }
}
