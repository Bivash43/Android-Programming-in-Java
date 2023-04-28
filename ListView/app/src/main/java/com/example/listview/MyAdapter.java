package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<StringText> {
    public MyAdapter(@NonNull Context context, ArrayList<StringText> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        StringText getDataPosition = getItem(position);

        ImageView imageView = view.findViewById(R.id.image);
        TextView textView1 = view.findViewById(R.id.text1);
        TextView textView2 = view.findViewById(R.id.text2);

        imageView.setImageResource(getDataPosition.images);
        textView1.setText(getDataPosition.text1);
        textView2.setText(getDataPosition.text2);

        return view;
    }
}
