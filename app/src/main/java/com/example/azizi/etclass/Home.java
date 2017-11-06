package com.example.azizi.etclass;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Azizi on 11/6/2017.
 */

public class Home extends android.support.v4.app.Fragment {

    public Home(){}
    View homeView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       homeView = inflater.inflate(R.layout.home, container, false);

        getActivity().setTitle("Home");

        return homeView;
    }

}
