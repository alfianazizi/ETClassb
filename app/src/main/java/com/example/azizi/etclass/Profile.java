package com.example.azizi.etclass;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

/**
 * Created by Azizi on 11/6/2017.
 */

public class Profile extends android.support.v4.app.Fragment {

    public Profile() {
    }

    public FirebaseAuth.AuthStateListener authListener;
    public FirebaseAuth auth;
    public TextView email;
    public TextView name;
    public TextView nim;
    public TextView angkatan;
    private FirebaseDatabase mDatabase;

    View profileView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        profileView = inflater.inflate(R.layout.profile, container, false);

        name = (TextView)profileView.findViewById(R.id.displayed_name);
        email = (TextView)profileView.findViewById(R.id.displayed_email);
        nim = (TextView)profileView.findViewById(R.id.displayed_nim);
        angkatan = (TextView)profileView.findViewById(R.id.displayed_angkatan);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        mDatabase =  FirebaseDatabase.getInstance();


        //get current user
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        DatabaseReference nameUser = mDatabase.getReference().child("user").child(user.getUid()).child("name");
        DatabaseReference nimUser = mDatabase.getReference().child("user").child(user.getUid()).child("nim");
        DatabaseReference angkatanUser = mDatabase.getReference().child("user").child(user.getUid()).child("angkatan");
        nameUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String displaynama = (String) dataSnapshot.getValue();
                name.setText("Nama: " + displaynama);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        email.setText("User Email: " + user.getEmail());

        nimUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String displaynim = (String) dataSnapshot.getValue();
                nim.setText("NIM: " + displaynim);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        angkatanUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String displayangkatan = (String) dataSnapshot.getValue();
                angkatan.setText("Angkatan: " + displayangkatan);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        getActivity().setTitle("Profile");

        return profileView;
    }
}
