package com.example.assignmentlistview;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ListViewDialog extends Dialog {
    private TextView title;
    private ListView listView;
    private Button btnOK;

    String listItems[] = {
            "Apple",
            "Orange",
            "Mango",
            "Grapes",
            "Banana",
    };

    public ListViewDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.activity_list_view_dialog);
        title = findViewById(R.id.titleListViewDialog);
        listView = findViewById(R.id.listView);
        btnOK = findViewById(R.id.btnDialogOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, listItems);

        listView.setAdapter(arrayAdapter);


        //ArrayAdapter<String> rameAdapter = new ArrayAdapter<>(ListViewDialog.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listItems);
        //listView.setAdapter(rameAdapter);
    }

}