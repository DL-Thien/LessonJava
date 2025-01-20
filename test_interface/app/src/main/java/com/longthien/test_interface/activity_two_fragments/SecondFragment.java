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

public class SecondFragment extends Fragment implements IDataTransfer {

    TextView textView;

    private IFragmentDataTransfer fragmentDataTransfer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        textView = view.findViewById(R.id.tvSecondFragment);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentDataTransfer.onFragmentReady(this);
    }

    void unregisterFragmentDataTransfer() {
        this.fragmentDataTransfer = null;
    }

    void registerIFragmentDataTransfer(IFragmentDataTransfer fragmentDataTransfer) {
        this.fragmentDataTransfer = fragmentDataTransfer;
    }

    @Override
    public void sendData(String data) {
        if (textView != null) {
            textView.setText(data);
        }
    }

}