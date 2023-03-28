package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment1.R;

public class HomeActivity extends AppCompatActivity {

    private TextView welcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        welcomeTextView = findViewById(R.id.welcome_text_view);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        welcomeTextView.setText("Hello " + email);
    }
}
