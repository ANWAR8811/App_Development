package com.example.loginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameEditText, passwordEditText, nameEditText, emailEditText;
    private Button signUpBtn;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameEditText = (EditText) findViewById(R.id.nameEditTextId);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextId);
        nameEditText = (EditText) findViewById(R.id.nameEditTextId);
        emailEditText = (EditText) findViewById(R.id.emailEditTextId);

        signUpBtn = (Button) findViewById(R.id.signUpButtonId);
        signUpBtn.setOnClickListener(this);

        databaseHelper = new DatabaseHelper(this);
        userDetails = new UserDetails();
    }

    @Override
    public void onClick(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();

        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);

        long rowId = databaseHelper.insertData(userDetails);

        if (rowId > 0) {
            Toast.makeText(getApplicationContext(), "Row "+rowId+" is successfully inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Row insertion failed", Toast.LENGTH_SHORT).show();
        }

    }
}