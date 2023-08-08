package com.example.datepickerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private DatePicker datePicker;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textViewId);
        datePicker = (DatePicker) findViewById(R.id.datePickerId);
        button = (Button) findViewById(R.id.btnId);

        textView.setText(currentDate());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(currentDate());
            }
        });
    }

    String currentDate() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Current Date: ");
        stringBuilder.append(datePicker.getDayOfMonth() + "/");
        stringBuilder.append((datePicker.getMonth()+1) + "/");
        stringBuilder.append(datePicker.getYear());

        return stringBuilder.toString();
    }
}