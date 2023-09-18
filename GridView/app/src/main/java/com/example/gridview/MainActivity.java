package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] flags = {R.drawable.afghanistan, R.drawable.armenia, R.drawable.azerbaijan,
            R.drawable.bahrain, R.drawable.bangladesh, R.drawable.bhutan,
            R.drawable.china, R.drawable.india, R.drawable.japan,
            R.drawable.nepal, R.drawable.pakistan, R.drawable.srilanka,
    };
    String[] countryNames;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_names);
        gridView = (GridView) findViewById(R.id.gridViewId);

        CustomAdapter adapter = new CustomAdapter(this, countryNames, flags);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = countryNames[i];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}