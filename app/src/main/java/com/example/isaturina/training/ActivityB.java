package com.example.isaturina.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(ActivityA.EXTRA_MESSAGE);

        // Create the text view
        setContentView(R.layout.activity_activity_b);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }
}
