package com.longthien.test_interface.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.longthien.test_interface.R;

public class FragmentOne extends Fragment {

    private FragmentOnClickListener mFragmentOnClickListener;
    private int mCount = 0;

    static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    void registerOnClickListener(FragmentOnClickListener fragmentOnClickListener) {
        mFragmentOnClickListener = fragmentOnClickListener;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonCount = view.findViewById(R.id.btn_count_value);
        buttonCount.setOnClickListener(v -> {
            mCount += 1;
            mFragmentOnClickListener.onClicked(mCount);
        });
    }
}
