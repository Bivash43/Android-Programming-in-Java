package com.example.activitytofrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    public TextView value;
    public Button button;
    public String data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        data=getArguments().getString("key");
        value = view.findViewById(R.id.textview_frg);
        button = view.findViewById(R.id.button_frg);
                value.setText(data);


        return view;
    }
}