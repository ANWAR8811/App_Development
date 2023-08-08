package com.example.searchviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<String> adapter;
    String[] countryNames;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewId);
        searchView = (SearchView) findViewById(R.id.searchViewId);
        countryNames = getResources().getStringArray(R.array.country_names);

//  Here in adapter R.id.textViewId is missing so the app is not working
        adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.sample_view, R.id.countryNameId,countryNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String value = adapter.getItem(i);
        Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
    }
}