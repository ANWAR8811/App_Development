package com.example.loginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelper databaseHelper;
    private Button signUpBtn, signInBtn;
    private EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInBtn = (Button) findViewById(R.id.signInBtnId);
        signUpBtn = (Button) findViewById(R.id.signUpBtnId);

        usernameEditText = (EditText) findViewById(R.id.signInUsernameEditTextId);
        passwordEditText = (EditText) findViewById(R.id.signInPasswordEditTextId);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        signInBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (view.getId() == R.id.signInBtnId) {
            Boolean result = databaseHelper.findPassword(username,password);

            if (result == true) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), "Username and Password didn't match", Toast.LENGTH_SHORT).show();
            }
        }
        else if (view.getId() == R.id.signUpBtnId) {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}