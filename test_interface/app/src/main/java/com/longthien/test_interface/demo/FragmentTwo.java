package com.longthien.test_interface.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.longthien.test_interface.R;

public class FragmentTwo extends Fragment implements FragmentOnClickListener {

    private TextView mTvValue;

    static FragmentTwo newInstance() {
        return new FragmentTwo();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvValue = view.findViewById(R.id.tv_value);
    }

    @Override
    public void onClicked(int value) {
        if (mTvValue != null) {
            mTvValue.setText("" + value);
        }
    }
}
