package com.longthien.test_interface.fragments;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.longthien.test_interface.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements IRegisterReceiveData {

    @Override
    public void onFragmentReady(ISendDataToFragments dataTransfer) {
        this.sendDataToFragments.add(dataTransfer);
    }

    public interface ISendDataToFragments {
        void sendData(String data);
    }

    private final ArrayList<ISendDataToFragments> sendDataToFragments = new ArrayList<>();
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        Fragment4 fragment4 = new Fragment4();
        Fragment5 fragment5 = new Fragment5();
        Fragment6 fragment6 = new Fragment6();


        //init fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainerFragment1, fragment1).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainerFragment2, fragment2).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainerFragment3, fragment3).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainerFragment4, fragment4).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainerFragment5, fragment5).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainerFragment6, fragment6).commit();

        fragment1.registerFragmentDataTransfer(this);
        fragment2.registerFragmentDataTransfer(this);
        fragment3.registerFragmentDataTransfer(this);
        fragment4.registerFragmentDataTransfer(this);
        fragment5.registerFragmentDataTransfer(this);
        fragment6.registerFragmentDataTransfer(this);

        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(v -> {
            this.i += 1;

            for (int i = 0; i < sendDataToFragments.size(); i++) {
                ISendDataToFragments sendDataToFragment = sendDataToFragments.get(i);
                String fragmentName = "";
                switch (i) {
                    case 0:
                        fragmentName = "Fragment 1";
                        break;
                    case 1:
                        fragmentName = "Fragment 2";
                        break;
                    case 2:
                        fragmentName = "Fragment 3";
                        break;
                    case 3:
                        fragmentName = "Fragment 4";
                        break;
                    case 4:
                        fragmentName = "Fragment 5";
                        break;
                    default:
                        fragmentName = "Fragment 6";
                        break;
                }
                sendDataToFragment.sendData("Hello " + fragmentName + " " + this.i);
            }
        });
    }
}