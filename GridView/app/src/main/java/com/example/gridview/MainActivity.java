package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<GridDataClass> glist = new ArrayList<GridDataClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid);
        glist.add(new GridDataClass(R.drawable.ic_launcher_background , "First Item"));
        glist.add(new GridDataClass(R.drawable.ic_launcher_background , "Second Item"));
        glist.add(new GridDataClass(R.drawable.ic_launcher_background , "Third Item"));
        glist.add(new GridDataClass(R.drawable.ic_launcher_background , "Fourth Item"));

        MyAdapter adapter = new MyAdapter(MainActivity.this , glist);
        gridView.setAdapter(adapter);
    }
}