package com.example.activitytofrag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    public TextView value;


    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_1, container, false);
        //data=getArguments().getString("key");
        value = view.findViewById(R.id.textview_frg);
        return view;
    }

    public void getData(String data){
        value.setText("Result = " + data);
    }

}
