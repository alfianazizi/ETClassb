package com.example.azizi.etclass;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Azizi on 11/6/2017.
 */

public class Profile extends android.support.v4.app.Fragment {

    public Profile() {
    }

    View profileView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        profileView = inflater.inflate(R.layout.profile, container, false);

        getActivity().setTitle("Profile");

        return profileView;
    }
}
