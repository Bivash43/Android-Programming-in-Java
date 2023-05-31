package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataInput extends AppCompatActivity {

    EditText uname;
    EditText upass;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_input);

        uname = findViewById(R.id.usersName);
        upass = findViewById(R.id.userPassword);
        submit = findViewById(R.id.submitBtn);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = uname.getText().toString();
                String pass = upass.getText().toString();

                DbHelper insert = new DbHelper(DataInput.this);

                insert.insertData(user,pass);
            }
        });

    }
}