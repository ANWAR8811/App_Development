package com.example.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nameText;
    private TextView ageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (TextView) findViewById(R.id.nameTextView);
        nameText.setText("Anwar Hossain");

        ageText = (TextView) findViewById(R.id.ageTextView);
        ageText.setText("21 years old");
    }
}