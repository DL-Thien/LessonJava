package com.longthien.test_interface.demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.longthien.test_interface.R;

public class HolderActivity extends AppCompatActivity {

    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);

        initFragments();
    }

    private void initFragments() {
        mFragmentOne = FragmentOne.newInstance();
        mFragmentTwo = FragmentTwo.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_1, mFragmentOne)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_2, mFragmentTwo)
                .commit();

        mFragmentOne.registerOnClickListener(mFragmentTwo);
    }
}
