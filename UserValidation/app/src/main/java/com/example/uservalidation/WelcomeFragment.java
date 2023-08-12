package com.example.uservalidation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WelcomeFragment extends Fragment {

    private static final String ARG_EMAIL = "email";

    private TextView textViewWelcomeMessage;

    public static WelcomeFragment newInstance(String email) {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_EMAIL, email);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        textViewWelcomeMessage = view.findViewById(R.id.textViewWelcomeMessage);

        Bundle args = getArguments();
        if (args != null) {
            String email = args.getString(ARG_EMAIL);
            if (email != null) {
                String welcomeMessage = "Hello, " + email.split("@")[0] + "!";
                textViewWelcomeMessage.setText(welcomeMessage);
            }
        }

        return view;
    }
}
