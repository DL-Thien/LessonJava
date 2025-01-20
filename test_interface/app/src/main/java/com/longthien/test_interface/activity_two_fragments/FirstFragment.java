package com.longthien.test_interface.activity_two_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.longthien.test_interface.R;

public class FirstFragment extends Fragment implements IDataTransfer {

    private IFragmentDataTransfer fragmentDataTransfer;
    private TextView textView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        textView = view.findViewById(R.id.tvFirstFragment);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.fragmentDataTransfer.onFragmentReady(this);
    }

    void registerFragmentDataTransfer(IFragmentDataTransfer fragmentDataTransfer) {
        this.fragmentDataTransfer = fragmentDataTransfer;
    }

    void unregisterFragmentDataTransfer() {
        this.fragmentDataTransfer = null;
    }

    @Override
    public void sendData(String data) {
        if (textView != null) {
            textView.setText(data);
        }
    }
}