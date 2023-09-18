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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signUpEmailEditText, signUpPassEditText;
    private TextView signInTextView;
    private Button signUpBtn;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign up Activity");

        mAuth = FirebaseAuth.getInstance();

        progressBar = (ProgressBar) findViewById(R.id.progressbarId);
        signUpEmailEditText = (EditText) findViewById(R.id.signUpEmailEditTextId);
        signUpPassEditText = (EditText) findViewById(R.id.signUpPassEditTextId);
        signInTextView = (TextView) findViewById(R.id.signInTextViewId);
        signUpBtn = (Button) findViewById(R.id.signUpBtnId);

        signInTextView.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signUpBtnId) {
            // Handle the sign-in button click
            userRegister();
        } else if (view.getId() == R.id.signInTextViewId) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

    private void userRegister() {
        String email = signUpEmailEditText.getText().toString().trim();
        String pass = signUpPassEditText.getText().toString().trim();

        //Checking validity of the email
        if (email.isEmpty()) {
            signUpEmailEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpEmailEditText.setError("Enter a valid email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        //Checking validity of the Password
        if (pass.isEmpty()) {
            signUpPassEditText.setError("Enter your password");
            signUpPassEditText.requestFocus();
            return;
        }
        if (pass.length() < 6) {
            signUpPassEditText.setError("Minimum length of password should be 6");
            signUpPassEditText.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

//                    Toast.makeText(getApplicationContext(), "Register is successful", Toast.LENGTH_SHORT).show();

                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "User is already registered", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}