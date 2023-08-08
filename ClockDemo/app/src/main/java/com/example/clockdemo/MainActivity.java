package com.example.clockdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AnalogClock analogClock;
    private TextClock textClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analogClock = (AnalogClock) findViewById(R.id.analogClockId);
        textClock = (TextClock) findViewById(R.id.textClockId);

        analogClock.setOnClickListener(this);
        textClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.analogClockId) {
            Toast.makeText(MainActivity.this, "Analog Clock", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Digital Clock", Toast.LENGTH_SHORT).show();
        }
    }
}