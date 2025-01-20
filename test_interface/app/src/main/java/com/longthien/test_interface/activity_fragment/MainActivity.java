package com.longthien.test_interface.activity_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.longthien.test_interface.R;
import com.longthien.test_interface.two_fragment.Activity2;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    //    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init fragment
        MyFragment myFragment = new MyFragment();
        //register fragment
//        myFragment.registerFragmentDataTransfer(this);
        //init fragment
        if (findViewById(R.id.Container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Container, myFragment)
                    .commit();
        }


        Button btn_Count = findViewById(R.id.btn_count);
        btn_Count.setOnClickListener(v -> {
            count++;
            myFragment.getData(this.count);
        });

        Button btn_Next = findViewById(R.id.btn_next);
        btn_Next.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
        });
    }

//    @Override
//    public void onFragmentReady(Handler handler) {
//        this.handler = handler;
//    }
}