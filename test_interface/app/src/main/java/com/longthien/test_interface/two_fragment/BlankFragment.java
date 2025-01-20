package com.longthien.test_interface.two_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.longthien.test_interface.R;


public class BlankFragment extends Fragment implements SendDataBetweenTwoFragments {

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        textView = view.findViewById(R.id.text);
        textView.setText(String.valueOf(0));
        return view;
    }

    @Override
    public void onPassData(int count) {
        if (textView != null) {
            textView.setText(String.valueOf(count));
        }
    }

}