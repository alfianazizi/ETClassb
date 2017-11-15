package com.example.azizi.etclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationFormActivity extends AppCompatActivity {

    private EditText inputUsername, inputName, inputNim, inputAngkatan;
    private Button btnSignUp;
    private ProgressBar progressBar;
    private DatabaseReference mDatabase;
    private DatabaseReference usernameUser, nameUser, nimUser, angkatanUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        mDatabase =  FirebaseDatabase.getInstance().getReference();
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        inputName = (EditText) findViewById(R.id.name);
        inputUsername = (EditText) findViewById(R.id.username);
        inputNim = (EditText) findViewById(R.id.nim);
        inputAngkatan = (EditText) findViewById(R.id.angkatan);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = inputUsername.getText().toString().trim();
                final String name = inputName.getText().toString().trim();
                final String nim = inputNim.getText().toString().trim();
                final String angkatan = inputAngkatan.getText().toString().trim();

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Masukkan Username!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Masukkan Nama!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(nim)) {
                    Toast.makeText(getApplicationContext(), "Masukkan Nim!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(angkatan)) {
                    Toast.makeText(getApplicationContext(), "Masukkan Angkatan!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                mDatabase.child(username).child("name").setValue(name);
                mDatabase.child(username).child("nim").setValue(nim);
                mDatabase.child(username).child("angkatan").setValue(angkatan);
                startActivity(new Intent(RegistrationFormActivity.this, MainActivity.class));
                finish();

            }
        });
    }
}
