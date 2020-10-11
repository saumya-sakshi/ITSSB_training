package com.microsoft.tutorial2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class Dropdown extends AppCompatActivity {


    String[] plants = { "Lettuce", "Coriander",
            "Mint", "Kale",
            "Spinach", "Red Spinach","Curryleaf","Micro Greens" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown);
        Spinner spinner = (Spinner)findViewById(R.id.spinner2);

        ListView listView = (ListView)findViewById(R.id.listview) ;


        ArrayAdapter araylist = new ArrayAdapter(Dropdown.this,R.layout.listitems,plants);


        listView.setAdapter(araylist);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Log.e("Selected Value",plants[position]);

                Toast.makeText(Dropdown.this, plants[position], Toast.LENGTH_SHORT).show();

            }
        });






        ArrayAdapter arrayAdapter = new ArrayAdapter(Dropdown.this, android.R.layout.simple_spinner_item, plants);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedvalue = plants[position];

                Log.e("selected Value",plants[position]);


                Toast.makeText(Dropdown.this, selectedvalue, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
