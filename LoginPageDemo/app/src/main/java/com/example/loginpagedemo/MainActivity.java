package com.example.loginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginBtn;
    private TextView textView;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = (EditText) findViewById(R.id.usernameId);
        passwordEditText = (EditText) findViewById(R.id.passwordId);
        loginBtn = (Button) findViewById(R.id.loginBtnId);
        textView = (TextView) findViewById(R.id.textViewId);
        textView.setText("Number of attempts remaining: " + counter);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals("admin") && password.equals("1234")) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
                else {
                    counter--;
                    textView.setText("Number of attempts remaining: " + counter);

                    if (counter == 0) {
                        loginBtn.setEnabled(false);
                    }

                }

            }
        });
    }
}