package com.example.uservalidation;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class InputFragment extends Fragment {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnValidate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        btnValidate = view.findViewById(R.id.btnValidate);

        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });

        return view;
    }

    private void validateInput() {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (email.contains("@thames") && password.length() < 8) {
            navigateToWelcomeFragment(email);
        } else {
            showErrorDialog();
        }
    }

    private void navigateToWelcomeFragment(String email) {
        WelcomeFragment welcomeFragment = WelcomeFragment.newInstance(email);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = ((FragmentManager) fragmentManager).beginTransaction();
        transaction.replace(R.id.fragmentContainer, welcomeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Validation Error")
                .setMessage("Input could not be verified.")
                .setPositiveButton("OK", null)
                .show();
    }
}
