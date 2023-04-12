package com.example.fragmentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentInterface{

    TextView txtview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtview = findViewById(R.id.tv1);
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.frg1,Frahment1.class,null).commit();
        }
    }

    @Override
    public void getDataFromFragment(String data) {
        txtview.setText(data);
    }
}