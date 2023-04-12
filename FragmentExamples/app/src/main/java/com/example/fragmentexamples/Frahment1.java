package com.example.fragmentexamples;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Frahment1 extends Fragment {

    private EditText text;
    private Button btn;

    FragmentInterface frgI;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        frgI = (FragmentInterface) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.fragment_frahment1, container, false);
        btn = view.findViewById(R.id.btn1);
        text = view.findViewById(R.id.txt1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = text.getText().toString();
                frgI.getDataFromFragment(value);
            }
        });


        return view;

    }
}