package com.example.sqlitedatabasedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText, ageEditText, genderEditText;
    private Button addBtn, displayAllDataBtn;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        nameEditText = (EditText) findViewById(R.id.editTextName);
        ageEditText = (EditText) findViewById(R.id.editTextAge);
        genderEditText = (EditText) findViewById(R.id.editTextGender);
        addBtn = (Button) findViewById(R.id.buttonData);
        displayAllDataBtn = (Button) findViewById(R.id.showAllButtonData);

        addBtn.setOnClickListener(this);
        displayAllDataBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
         String name = nameEditText.getText().toString();
         String age = ageEditText.getText().toString();
         String gender = genderEditText .getText().toString();

         if (view.getId()==R.id.buttonData) {
             long rowId = databaseHelper.insertData(name, age, gender);

             if (rowId == -1) {
                 Toast.makeText(getApplicationContext(), "Unsuccessful", Toast.LENGTH_SHORT).show();
             }
             else {
                 Toast.makeText(getApplicationContext(), "Row "+rowId+" is successfully inserted", Toast.LENGTH_SHORT).show();

             }
         }

         if (view.getId() == R.id.showAllButtonData) {
             Cursor resultSet = databaseHelper.displayAllData();
             if (resultSet.getCount() == 0) {
                 showData("Error", "No data found");
                 return;
             }
             StringBuffer stringBuffer = new StringBuffer();
             while (resultSet.moveToNext()) {
                 stringBuffer.append("ID: "+resultSet.getString(0) + "\n");
                 stringBuffer.append("Name: "+resultSet.getString(1) + "\n");
                 stringBuffer.append("Age: "+resultSet.getString(2) + "\n");
                 stringBuffer.append("Gender: "+resultSet.getString(3) + "\n\n");
             }
             showData("ResultSEt", stringBuffer.toString());
         }
    }
    public void showData(String title, String data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(data);
        builder.setCancelable(true);
        builder.show();
    }
}