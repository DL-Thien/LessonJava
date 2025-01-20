package com.longthien.test_interface.activity_two_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.longthien.test_interface.R;
import com.longthien.test_interface.fragments.SecondActivity;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity implements IFragmentDataTransfer {

    private final ArrayList<IDataTransfer> dataTransfers = new ArrayList<>();
    private int i = 0;


    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);


        Button btnSend = findViewById(R.id.btnSend);
        Button btnNext = findViewById(R.id.btnNext);
        // init fragment dau tien
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.firstFragment, firstFragment)
                .commit();

        // init fragment sau
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.secondFragment, secondFragment)
                .commit();

        firstFragment.registerFragmentDataTransfer(this);
        secondFragment.registerIFragmentDataTransfer(this);

        btnSend.setOnClickListener(v -> {
            this.i += 1;
            for (int i = 0; i < dataTransfers.size(); i++) {
                IDataTransfer dataTransfer = dataTransfers.get(i);
                String fragmentName = "";
                if (i == 0) {
                    fragmentName = "First Fragment";
                } else if (i == 1) {
                    fragmentName = "Second Fragment";
                }

                dataTransfer.sendData("Hello " + fragmentName + " " + this.i);
            }
        });

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
//        firstFragment.unregisterFragmentDataTransfer();
//        secondFragment.unregisterFragmentDataTransfer();
    }

    int a = 0;

    @Override
    public void onFragmentReady(IDataTransfer dataTransfer) {
        Log.d("ANDEBUGGG", "onFragmentReady: " + (a += 1));
        dataTransfers.add(dataTransfer);
    }
}

// pub/sub pattern