package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button listBtn1 , listBtn2,  gridBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listBtn1 = findViewById(R.id.list1);
        listBtn2 = findViewById(R.id.list2);
        gridBtn = findViewById(R.id.grid);

        listBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tutorial[]={"1","2","3","4","5","6","7","8","9","10"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,tutorial);
        listView.setAdapter(arrayAdapter);
            }
        });
    }
}