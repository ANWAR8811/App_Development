package com.example.customadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] countryNames;
    int[] flags = {R.drawable.afghanistan, R.drawable.armenia, R.drawable.azerbaijan,
            R.drawable.bahrain, R.drawable.bangladesh, R.drawable.bhutan,
            R.drawable.china, R.drawable.india, R.drawable.japan,
            R.drawable.nepal, R.drawable.pakistan, R.drawable.srilanka
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_names);

        listView = (ListView) findViewById(R.id.listViewId);

        CustomAdapter adapter = new CustomAdapter(this, countryNames, flags);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = countryNames[i];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}