package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (isValidEmail(email) && isValidPassword(password)) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid email or password. Please Input valid email and password length >6", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidEmail(String email) {
        return email.contains("@gmail.com");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 6;
    }
}