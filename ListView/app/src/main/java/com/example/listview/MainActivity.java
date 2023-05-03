package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //String tutorial[]={"1","2","3","4","5","6","7","8","9","10"};
    ListView listView;
    ArrayList<StringText> listShow = new ArrayList<StringText>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,tutorial);
//        listView.setAdapter(arrayAdapter);

        listShow.add(new StringText(R.drawable.ic_launcher_background , "Hello World!!" , "How are you?"));
        listShow.add(new StringText(R.drawable.ic_launcher_background , "Goodbye Everyone!!" , "I am fine."));

        MyAdapter adapter = new MyAdapter(MainActivity.this,listShow);
        listView.setAdapter(adapter);

    }
}