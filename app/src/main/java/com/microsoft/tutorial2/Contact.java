package com.microsoft.tutorial2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class Contact extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ListView listView;
    String[] plants = { "Lettuce", "Coriander",
            "Mint", "Kale",
            "Spinach", "Red Spinach","Curryleaf","Micro Greens" };
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        listView = (ListView)findViewById(R.id.list);

        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,plants);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(this);


        ArrayAdapter adapter2 = new ArrayAdapter(this, R.layout.listitem,plants);
// Specify the layout to use when the list of choices appears

// Apply the adapter to the spinner
        listView.setAdapter(adapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Log.e("Item",plants[position]);
            }
        });




    String Sharedfilename = "com.microsoft.tutorial2";


        SharedPreferences Preferences = getSharedPreferences(Sharedfilename,MODE_PRIVATE);


        SharedPreferences.Editor preferenceEditer = Preferences.edit();

        preferenceEditer.putString("id","1");
//        preferenceEditer.clear();
        preferenceEditer.apply();
        String value = Preferences.getString("id","99999");

        Log.e("Saved",value);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        Log.e("position",plants[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
