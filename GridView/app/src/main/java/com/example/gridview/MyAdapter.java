package com.example.gridview;

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

public class MyAdapter extends ArrayAdapter<GridDataClass> {
    public MyAdapter(@NonNull Context context, ArrayList<GridDataClass> list) {
        super(context, 0 , list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.design,parent,false);
        GridDataClass getData = getItem(position);

        ImageView img = view.findViewById(R.id.image);
        TextView txt = view.findViewById(R.id.text);

        img.setImageResource(getData.images);
        txt.setText(getData.text);

        return view;
    }
}
