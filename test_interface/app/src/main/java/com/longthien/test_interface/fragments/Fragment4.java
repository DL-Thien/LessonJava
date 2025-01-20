package com.longthien.test_interface.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.longthien.test_interface.R;

public class Fragment4 extends Fragment implements SecondActivity.ISendDataToFragments {

    TextView textView;
    IRegisterReceiveData registerReceiveData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_4, container, false);
        textView = view.findViewById(R.id.tvFragment4);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.registerReceiveData.onFragmentReady(this);
    }

    void registerFragmentDataTransfer(IRegisterReceiveData registerReceiveData) {
        this.registerReceiveData = registerReceiveData;
    }

    @Override
    public void sendData(String data) {
        if (textView != null) {
            textView.setText(data);
        }
    }
}