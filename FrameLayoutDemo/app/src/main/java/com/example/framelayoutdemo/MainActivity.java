package com.example.framelayoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView bangladesh;
    private ImageView nepal;
    private ImageView japan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bangladesh = (ImageView) findViewById(R.id.bdImageViewId);
        nepal = (ImageView) findViewById(R.id.nepalImageViewId);
        japan = (ImageView) findViewById(R.id.japanImageViewId);

        bangladesh.setOnClickListener(this);
        nepal.setOnClickListener(this);
        japan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bdImageViewId) {
            bangladesh.setVisibility(View.GONE);
            japan.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.japanImageViewId) {
            japan.setVisibility(View.GONE);
            nepal.setVisibility(View.VISIBLE);
        }
        else if (view.getId() == R.id.nepalImageViewId) {
            nepal.setVisibility(View.GONE);
            bangladesh .setVisibility(View.VISIBLE);
        }
    }
}