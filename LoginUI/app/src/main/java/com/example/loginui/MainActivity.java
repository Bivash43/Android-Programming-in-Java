package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView login;

    EditText email, password;

    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email);
        password=findViewById(R.id.pass);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailTxt=email.getText().toString();
                Toast.makeText(MainActivity.this,emailTxt, Toast.LENGTH_SHORT).show();
            }
        });

        Intent i = new Intent(MainActivity.this,MainActivity2.class);
        i.putExtra("key" , "This is from Activity 1");
        startActivity(i);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Bca", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Bca", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Bca", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Bca", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Bca", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Bca", "onRestart");
    }
}