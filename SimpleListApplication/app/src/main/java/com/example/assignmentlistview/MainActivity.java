package com.example.assignmentlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView titleText;
    private Button listViewBtn, listViewWithPictureBtn, gridViewBtn;

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewBtn = findViewById(R.id.btnListView);
        listViewWithPictureBtn = findViewById(R.id.btnListViewWithImage);
        gridViewBtn = findViewById(R.id.btnGridView);

        listViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListViewDialog listViewDialog = new ListViewDialog(MainActivity.this);
                listViewDialog.setCancelable(false);
                listViewDialog.show();

            }
        });

        listViewWithPictureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageListViewDialog imageListViewDialog = new ImageListViewDialog(MainActivity.this);
                imageListViewDialog.setCancelable(false);
                imageListViewDialog.show();
            }
        });

        gridViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GridViewDialog gridViewDialog = new GridViewDialog(MainActivity.this);
                gridViewDialog.setCancelable(false);
                gridViewDialog.show();
            }
        });
    }
}