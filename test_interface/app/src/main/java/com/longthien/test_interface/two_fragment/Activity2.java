package com.longthien.test_interface.two_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.longthien.test_interface.R;
import com.longthien.test_interface.activity_two_fragments.FirstActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);

        BlankFragment blankFragment = new BlankFragment();
        BlankFragmentB blankFragmentB = new BlankFragmentB();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Container_Text, blankFragment).commit();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Container_Button, blankFragmentB).commit();
        }

        blankFragmentB.registerSendData(blankFragment);

        Button btn_Next = findViewById(R.id.btn_next_activity2);
        btn_Next.setOnClickListener(v -> {
            Intent intent = new Intent(Activity2.this, FirstActivity.class);
            startActivity(intent);
        });
    }
}
