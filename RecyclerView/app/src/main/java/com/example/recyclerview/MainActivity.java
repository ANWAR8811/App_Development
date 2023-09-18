package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] images = {R.drawable.afghanistan,R.drawable.armenia,R.drawable.azerbaijan,
            R.drawable.bahrain,R.drawable.bangladesh,R.drawable.bhutan,
            R.drawable.china,R.drawable.india,R.drawable.japan,
            R.drawable.nepal,R.drawable.pakistan,R.drawable.srilanka};
    Adapter adapter;
    String[] title, description;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);

        title = getResources().getStringArray(R.array.country_names);
        description = getResources().getStringArray(R.array.country_description);

        adapter = new Adapter(this, title, description, images);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new Adapter.ClickListener() {
            @Override
            public Void onItemClick(int position, View view) {
                Toast.makeText(getApplicationContext(), "onItem clicked: "+position, Toast.LENGTH_SHORT).show();
                return null;
            }

            @Override
            public Void onItemLongClick(int position, View view) {
                Toast.makeText(getApplicationContext(), "onItemLong clicked: "+position, Toast.LENGTH_SHORT).show();
                return null;
            }
        });
    }
}