package com.example.firebaselogindemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signInEmailEditText, signInPassEditText;
    private TextView signUpTextView;
    private Button signInBtn;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign in Activity");

        mAuth = FirebaseAuth.getInstance();

        signInEmailEditText = (EditText) findViewById(R.id.signInEmailEditTextId);
        signInPassEditText = (EditText) findViewById(R.id.signInPassEditTextId);
        signUpTextView = (TextView) findViewById(R.id.signUpTextViewId);
        signInBtn = (Button) findViewById(R.id.signInBtnId);

        progressBar = (ProgressBar) findViewById(R.id.progressbarId);

        signUpTextView.setOnClickListener(this);
        signInBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signInBtnId) {
            // Handle the sign-in button click
            userLogin();

        } else if (view.getId() == R.id.signUpTextViewId) {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
        }
    }

    private void userLogin() {
        String email = signInEmailEditText.getText().toString().trim();
        String pass = signInPassEditText.getText().toString().trim();

        //Checking validity of the email
        if (email.isEmpty()) {
            signInEmailEditText.setError("Enter an email address");
            signInEmailEditText.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signInEmailEditText.setError("Enter a valid email address");
            signInEmailEditText.requestFocus();
            return;
        }

        //Checking validity of the Password
        if (pass.isEmpty()) {
            signInPassEditText.setError("Enter your password");
            signInPassEditText.requestFocus();
            return;
        }
        if (pass.length() < 6) {
            signInPassEditText.setError("Minimum length of password should be 6");
            signInPassEditText.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}