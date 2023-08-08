package com.example.edittextdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1, editText2;
    private Button addBtn, subBtn;
    private TextView resText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1Id);
        editText2 = (EditText) findViewById(R.id.editText2Id);

        addBtn = (Button) findViewById(R.id.addBtnId);
        subBtn = (Button) findViewById(R.id.subBtnId);

        resText = (TextView) findViewById(R.id.resTextViewId);

        addBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        try {
            String num1 = editText1.getText().toString();
            String num2 = editText2.getText().toString();

            //converting into double
            double nd1 = Double.parseDouble(num1);
            double nd2 = Double.parseDouble(num2);

            if (view.getId() == R.id.addBtnId) {
                double sum = nd1 + nd2;
                resText.setText("Result: "+sum);
            }
            else if (view.getId() == R.id.subBtnId) {
                double sub = nd1 - nd2;
                resText.setText("Result: "+sub);
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Please enter two numbers", Toast.LENGTH_SHORT).show();
        }


    }
}