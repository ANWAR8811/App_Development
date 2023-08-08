package com.example.buttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn, logoutBtn;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button) findViewById(R.id.loginBtnId);
        logoutBtn = (Button) findViewById(R.id.logoutBtnId);
        textView = (TextView) findViewById(R.id.textViewId);

//        Handler handler = new Handler();
//
//        loginBtn.setOnClickListener(handler);
//        logoutBtn.setOnClickListener(handler);
    }

//    class Handler implements View.OnClickListener {
//
//        @Override
//        public void onClick(View view) {
//            if (view.getId() == R.id.loginBtnId) {
//                textView.setText("Login button is clicked");
//            }
//
//            if (view.getId() == R.id.logoutBtnId) {
//                textView.setText("Logout button is clicked");
//            }
//        }
//    }

    public void showMessage(View view) {
        if (view.getId() == R.id.loginBtnId) {
//            textView.setText("Login Button is clicked");
//            Toast.makeText(MainActivity.this, "Login Button is clicked", Toast.LENGTH_SHORT).show();
//            Toast toast = Toast.makeText(MainActivity.this, "Login Button is clicked", Toast.LENGTH_SHORT);
//            toast.setGravity(Gravity.CENTER, 0,0);
//            toast.show();
            Log.d("tag", "Login Button is clicked");
        }
        else {
//            textView.setText("Logout Button is clicked");
//            Toast.makeText(MainActivity.this, "Logout Button is clicked", Toast.LENGTH_SHORT).show();
//            Toast toast = Toast.makeText(MainActivity.this, "Logout Button is clicked", Toast.LENGTH_SHORT);
//            toast.setGravity(Gravity.CENTER, 0,0);
//            toast.show();
            Log.d("tag", "Logout Button is clicked");

        }
    }
}