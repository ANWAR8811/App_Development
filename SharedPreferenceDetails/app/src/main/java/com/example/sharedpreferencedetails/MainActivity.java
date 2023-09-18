package com.example.sharedpreferencedetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView detailsTextView;
    private EditText userNameEditText, passwordEditText;
    private Button saveBtn, loadBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailsTextView = (TextView) findViewById(R.id.detailsTextViewId);
        userNameEditText = (EditText) findViewById(R.id.userNameEditTextId);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextId);
        saveBtn = (Button) findViewById(R.id.saveBtnId);
        loadBtn = (Button) findViewById(R.id.loadBtnId);

        saveBtn.setOnClickListener(this);
        loadBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.saveBtnId) {
            String userName = userNameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (userName.equals("") && password.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter valid data", Toast.LENGTH_SHORT).show();
            }
            else {
                // Writing data
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userNameKey", userName);
                editor.putString("passwordKey", password);
                editor.commit();
                userNameEditText.setText("");
                passwordEditText.setText("");

                Toast.makeText(getApplicationContext(), "Data is stored successfully", Toast.LENGTH_SHORT).show();

            }
        }
        else if (view.getId() == R.id.loadBtnId) {
            // Reading data
            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);

            if (sharedPreferences.contains("userNameKey") && sharedPreferences.contains("passwordKey")) {
                String username = sharedPreferences.getString("userNameKey", "Data not found");
                String password = sharedPreferences.getString("passwordKey", "Data not found");

                detailsTextView.setText(username + "\n" + password);
            }
        }
    }
}