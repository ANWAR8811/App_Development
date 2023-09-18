package com.example.listviewdatabasaedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseHelper databaseHelper;
    private EditText nameEditText, idEditText;
    private Button saveBtn, deleteBtn, upgradeBtn, showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        idEditText = (EditText) findViewById(R.id.idEditText);

        saveBtn = (Button) findViewById(R.id.saveBtnId);
        showBtn = (Button) findViewById(R.id.showBtnId);
        upgradeBtn = (Button) findViewById(R.id.upgradeBtnId);
        deleteBtn = (Button) findViewById(R.id.deleteBtnId);

        saveBtn.setOnClickListener(this);
        showBtn.setOnClickListener(this);
        upgradeBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String id = idEditText.getText().toString();
        String name = nameEditText.getText().toString();

        if (view.getId()==R.id.saveBtnId) {
            if (id.equals("") && name.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter all the data", Toast.LENGTH_SHORT).show();
            } else {
                long rowNumber = databaseHelper.saveData(id, name);
                if (rowNumber > -1) {
                    Toast.makeText(getApplicationContext(), "Data is inserted successfully", Toast.LENGTH_SHORT).show();
                    idEditText.setText("");
                    nameEditText.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Data insertion failed", Toast.LENGTH_SHORT).show();

                }
            }
        }
        else if (view.getId()==R.id.showBtnId) {
            Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
            startActivity(intent);

        }
        else if (view.getId()==R.id.upgradeBtnId) {
            Boolean isUpdated = databaseHelper.updateData(id, name);
            if (isUpdated == true) {
                Toast.makeText(getApplicationContext(), "Data is updated", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Data is not updated", Toast.LENGTH_SHORT).show();
            }
        }
        else if (view.getId()==R.id.deleteBtnId) {
            int value = databaseHelper.deleteData(id);
            if (value < 0) {
                Toast.makeText(getApplicationContext(), "Data is not deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Data is deleted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}