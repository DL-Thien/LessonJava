package com.longthien.test_interface.fragments;

import com.longthien.test_interface.activity_two_fragments.IFragmentDataTransfer;

public interface IRegisterReceiveData {
    void onFragmentReady(SecondActivity.ISendDataToFragments dataTransfer);
}
