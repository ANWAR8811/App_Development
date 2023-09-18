package com.example.feedbackmenudemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendBtn, clearBtn;
    private EditText nameEditText, messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        sendBtn = (Button) findViewById(R.id.sendBtnId);
        clearBtn = (Button) findViewById(R.id.clearBtnId);

        nameEditText = (EditText) findViewById(R.id.nameEditTextId);
        messageEditText = (EditText) findViewById(R.id.messageEditTextId);

        sendBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        try {
            String name = nameEditText.getText().toString();
            String message = messageEditText.getText().toString();

            if (view.getId() == R.id.sendBtnId) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ranakrphone@gmail.com"});

                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
                intent.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\nMessage: " + message);
                startActivity(Intent.createChooser(intent, "Feedback with"));
            } else if (view.getId() == R.id.clearBtnId) {
                nameEditText.setText("");
                messageEditText.setText("");
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Exception: " + e, Toast.LENGTH_SHORT).show();
        }


    }
}