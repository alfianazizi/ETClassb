package com.example.azizi.etclass;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Azizi on 11/6/2017.
 */

public class Setting extends android.support.v4.app.Fragment {

    public Setting(){}
    View settingView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        settingView = inflater.inflate(R.layout.setting, container, false);

        getActivity().setTitle("Setting");

        return settingView;
    }

}