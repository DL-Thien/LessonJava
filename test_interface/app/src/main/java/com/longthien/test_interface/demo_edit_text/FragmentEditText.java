package com.longthien.test_interface.demo_edit_text;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.longthien.test_interface.R;

import java.util.regex.Pattern;

public class FragmentEditText extends Fragment {

    static FragmentEditText newInstance() {
        return new FragmentEditText();
    }

    OnValidateListener mListener;

    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPassword;
    String password = null;
    String email = null;
    String name = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_text, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtEmail = view.findViewById(R.id.edt_email);
        edtName = view.findViewById(R.id.edt_name);
        edtPassword = view.findViewById(R.id.edt_password);
    }

    void validateInput(TextView tvStatus, ImageView checkbox) {
        name = edtName.getText().toString();
        password = edtPassword.getText().toString();
        email = edtEmail.getText().toString();
        if (name.isEmpty()) {
            tvStatus.setText("Please enter your name!");
            tvStatus.setTextColor(Color.RED);
            checkbox.setImageResource(0);
        } else {
            mListener.onValidated(isValidEmailAndPassword(name, email, password));
        }
    }

    void setOnValidationListener(OnValidateListener listener) {
        mListener = listener;
    }

    boolean isValidEmailAndPassword(String name, String email, String password) {
        String NAME_REGEX = "[a-zA-Z]{1,50}";
        //Regular expression for valid email
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
        // Regular expression for valid password (at least 8 characters, with letters and digits)
        String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

        return Pattern.compile(NAME_REGEX).matcher(name).matches() && Pattern.compile(EMAIL_REGEX).matcher(email).matches() && Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }

}
