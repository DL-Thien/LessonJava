package com.longthien.lesson.passdata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.longthien.lesson.R;

public class MainActivity extends AppCompatActivity {
    String email;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPassword = findViewById(R.id.edtPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        edtEmail.setText("longthien@gmail.com");
        edtPassword.setText("123456");

        btnLogin.setOnClickListener(view -> {
            email = edtEmail.getText().toString();
            password = edtPassword.getText().toString();
            Singleton.getInstance().setEmail(email);
            Singleton.getInstance().setPassword(password);
            if (email.equals("longthien@gmail.com") && password.equals("123456")) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });
    }

}