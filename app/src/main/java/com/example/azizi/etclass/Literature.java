package com.example.azizi.etclass;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Azizi on 11/6/2017.
 */

public class Literature extends android.support.v4.app.Fragment {

    public Literature(){}
    View literatureView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        literatureView = inflater.inflate(R.layout.literature, container, false);

        getActivity().setTitle("Literature");

        return literatureView;
    }

}