package com.microsoft.tutorial2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Page2 extends AppCompatActivity {


    String countryname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        savedInstanceState.putString("password/Token","XXXXXXXXXXXXXXX");


        if (savedInstanceState!=null) {
            String Tokenvalue = savedInstanceState.getString("password/Token");
            Log.e("tokenvalue",Tokenvalue);

        }



        setContentView(R.layout.page2);


        Bundle getdata = getIntent().getExtras();



        countryname = getdata.getString("country");

        Log.e("Data received",countryname);

        Log.e("Data received",getdata.getString("rollno"));
        Log.e("Data received",getdata.getString("rollno1"));
        Log.e("Data received",getdata.getString("rollno2"));
        Log.e("Data received",countryname);




//
//        if (getdata!=null) {
//            String k = getdata.getString("K");
//
//            Log.e("value", k);
//        }
    }



    protected void onResume() {

        super.onResume();




    }

    protected void onStop() {


        super.onStop();



    }

    protected void onDestroy() {


        super.onDestroy();




    }


}
