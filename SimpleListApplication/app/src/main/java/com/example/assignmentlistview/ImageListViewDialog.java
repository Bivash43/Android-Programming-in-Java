package com.example.assignmentlistview;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ImageListViewDialog extends Dialog {
    private ListAdapter listAdapter;
    ArrayList<ListData> imgList = new ArrayList<ListData>();
    private TextView title;
    private ListView listView;
    private Button btnOK;

    public ImageListViewDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.activity_image_list_view_dialog);
        title = findViewById(R.id.titleImageListViewDialog);
        listView = findViewById(R.id.imageListView);
        btnOK = findViewById(R.id.btnDialogOK);

        imgList.add(new ListData(R.drawable.apple, "Apple"));
        imgList.add(new ListData(R.drawable.orange, "Orange"));
        imgList.add(new ListData(R.drawable.mango, "Mango"));
        imgList.add(new ListData(R.drawable.grapes, "Grapes"));
        imgList.add(new ListData(R.drawable.banana, "Banana"));

        listAdapter = new ListAdapter(context, imgList);
        listView.setAdapter(listAdapter);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }
}