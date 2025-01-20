package com.longthien.test_interface.two_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.longthien.test_interface.R;

public class BlankFragmentB extends Fragment {
    int count = 0;
    SendDataBetweenTwoFragments sendData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_b, container, false);
        Button btn_Count = view.findViewById(R.id.btn_count);
        btn_Count.setOnClickListener(v -> {
            this.count++;
            sendData.onPassData(this.count);
        });
        return view;
    }
    public void registerSendData(SendDataBetweenTwoFragments sendData) {
        this.sendData = sendData;
    }
}