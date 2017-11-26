package com.example.azizi.etclass;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by Azizi on 11/6/2017.
 */

public class Literature extends android.support.v4.app.Fragment implements AdapterView.OnItemSelectedListener {

    public Literature(){}
    public String selectedSemester;
    View literatureView;
    Spinner spinner1, spinner2;
    public Button btnSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        literatureView = inflater.inflate(R.layout.literature, container, false);

        getActivity().setTitle("Literature");

        spinner1 = (Spinner)literatureView.findViewById(R.id.semester);
        spinner2 = (Spinner)literatureView.findViewById(R.id.pelajaran);

        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.semester_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter);

        addListenerOnButton();

        return literatureView;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
            selectedSemester = parent.getItemAtPosition(pos).toString();
            addItemsOnSpinner2();
        }
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    private void addListenerOnButton() {
        btnSearch = (Button)literatureView.findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),
                        "OnClickListener : " +
                                "\nSemester : "+ String.valueOf(spinner1.getSelectedItem()) +
                                "\nCourse  : "+ String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();

                String pilihanCourse = String.valueOf(spinner2.getSelectedItem());
                Intent intent = new Intent(getActivity(), ViewUploadsActivity.class);
                        intent.putExtra("path", pilihanCourse);
                startActivity(intent);
            }

        });
    }



    public void addItemsOnSpinner2() {

        spinner2 = (Spinner)literatureView.findViewById(R.id.pelajaran);
        List<String> list = new ArrayList<String>();
        if (selectedSemester.equalsIgnoreCase("Semester 1")){
            list.add("RL");
            list.add("SISDIG");
        } else if (selectedSemester.equalsIgnoreCase("Semester 2")){
            list.add("PSWK");
            list.add("MEDAN1");
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }
}