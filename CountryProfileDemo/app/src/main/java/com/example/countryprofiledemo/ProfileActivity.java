package com.example.countryprofiledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = (ImageView) findViewById(R.id.imageViewId);
        textView = (TextView) findViewById(R.id.textViewId);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String countryName = bundle.getString("name");
            showDetails(countryName);
        }
    }

    void showDetails(String cName) {
        if (cName.equals("bangladesh")) {
            imageView.setImageResource(R.drawable.nationalmemmorialfront);
            textView.setText(R.string.bd_text);
        }
        if (cName.equals("india")) {
            imageView.setImageResource(R.drawable.tahmahal);
            textView.setText(R.string.india_text);
        }
        if (cName.equals("pakistan")) {
            imageView.setImageResource(R.drawable.pakistanmonument);
            textView.setText(R.string.pak_text);
        }
    }
}