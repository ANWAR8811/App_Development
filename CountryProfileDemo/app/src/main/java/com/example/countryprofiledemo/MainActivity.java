package com.example.countryprofiledemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bdBtn, indBtn, pakBtn;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bdBtn = (Button) findViewById(R.id.bdBtnId);
        indBtn = (Button) findViewById(R.id.indiaBtnId);
        pakBtn = (Button) findViewById(R.id.pakBtnId);

        bdBtn.setOnClickListener(this);
        indBtn.setOnClickListener(this);
        pakBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bdBtnId) {
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "bangladesh");
            startActivity(intent);
        }
        if (view.getId() == R.id.indiaBtnId) {
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "india");
            startActivity(intent);
        }
        if (view.getId() == R.id.pakBtnId) {
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "pakistan");
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setIcon(R.drawable.pcbbd);
        alertDialogBuilder.setTitle("Exit");
        alertDialogBuilder.setMessage("Do you wanna exit?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}