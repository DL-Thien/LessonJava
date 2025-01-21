package com.longthien.lesson.passdata;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.longthien.lesson.R;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HolderDataFragment holderDataFragment = new HolderDataFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, holderDataFragment).commit();


        Button btnGetData = findViewById(R.id.btnGetData);
        btnGetData.setOnClickListener(view -> {
            String email = Singleton.getInstance().getEmail();
            String password = Singleton.getInstance().getPassword();
            holderDataFragment.setData(email, password);
        });
    }
}
