package com.example.plaintext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        TextView text = findViewById(R.id.bemVindo);
        Intent intent = getIntent();
        String login = intent.getStringExtra("login");

        text.setText("Olá " + login + "!");

    }
}