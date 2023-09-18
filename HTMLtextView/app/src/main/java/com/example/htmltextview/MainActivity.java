package com.example.htmltextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    String myText = "<h1>This is heading 1</h1>\n" +
            "<h2>This is heading 1</h2>\n" +
            "<h3>This is heading 1</h3>\n" +
            "<p>This is paragraph</p>\n" +
            "<p><u>This is underline</u></p>\n" +
            "<p><b>This is bold</u></b>\n" +
            "<p><i>This is italic</u></i>\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textViewId);
        textView.setText(Html.fromHtml(myText));
    }
}