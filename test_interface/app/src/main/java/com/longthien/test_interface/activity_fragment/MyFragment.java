package com.longthien.test_interface.activity_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.longthien.test_interface.R;
import com.longthien.test_interface.fragments.IRegisterReceiveData;


public class MyFragment extends Fragment implements Handler {

    interface IRegisterSendData{
        void onFragmentReady(Handler handler);
    }

    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_my, container, false);
        textView = view.findViewById(R.id.text);
        textView.setText(String.valueOf(0));
        return view;
    }

    void registerFragmentDataTransfer(IRegisterSendData registerSendData){
        registerSendData.onFragmentReady(this);
    }

    @Override
    public void getData(int count) {
        if (textView != null) {
            textView.setText(String.valueOf(count));
        }
        Log.d("THIEN", "getData: " + count);
    }
}