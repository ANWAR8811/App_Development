package com.example.radiobuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button showBtn;
    private TextView resText;
    private RadioButton genderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        showBtn = (Button) findViewById(R.id.showBtnId);
        resText = (TextView) findViewById(R.id.resTextViewId);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                genderBtn = (RadioButton) findViewById(selectedId);

                String value = genderBtn.getText().toString();
                resText.setText("You have selected: "+value);
            }
        });
    }
}