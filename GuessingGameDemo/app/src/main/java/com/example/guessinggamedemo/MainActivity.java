package com.example.guessinggamedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button checkBtn;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextId);
        checkBtn = (Button) findViewById(R.id.checkBtnId);
        resultTextView = (TextView) findViewById(R.id.resultTextViewId);

        checkBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String guessString = editText.getText().toString();
        if (guessString.isEmpty()) {
            errorMessage();
        } else {
            int guess = Integer.parseInt(guessString);
            if (guess > 5) {
                errorMessage();
            } else {
                // Generating random number between 1 and 5
                Random random = new Random();
                int randomNumber = random.nextInt(5) + 1;

                if (randomNumber == guess) {
                    resultTextView.setText("Congratulations !!! You have won");
                } else {
                    resultTextView.setText("Sorry ! You have lost. Random number was " + randomNumber);
                }
            }


        }
    }
    void errorMessage() {
        editText.setError("please enter valid input");
        editText.requestFocus();
        return;
    }
}