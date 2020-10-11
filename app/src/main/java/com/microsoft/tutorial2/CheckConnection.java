package com.microsoft.tutorial2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CheckConnection extends AppCompatActivity {

    TextView textView;
    ListView listView;
    List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_connection);
        textView = (TextView)findViewById(R.id.textView);

        listView = (ListView)findViewById(R.id.listview);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();



        if (networkInfo != null && networkInfo.isConnected()) {


            Log.e("Status","Internet is Available");

            Toast.makeText(this, "Internet Available", Toast.LENGTH_SHORT).show();



            new JSonTask().execute();


            // Create background thread to connect and get data
          //  new DownloadWebpageTask().execute(stringUrl);
        }


        else {
            Log.e("Status","Internet is Not Available");
            Toast.makeText(this, "INternet is not available", Toast.LENGTH_SHORT).show();
            ///textView.setText("No network connection available.");
        }

    }


    public class JSonTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {


            Log.e("status", "came inside");
            super.onPreExecute();


        }

        @Override
        protected String doInBackground(String... params) {

            String result =null;

            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL("http://api.plos.org/search?q=title:DNA");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line=reader.readLine())!= null){
                    buffer.append(line);

                }




                return buffer.toString();




        //        jsonObject = new JSONObject(FinalJson);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



            return null;

        }


        @Override
        protected void onPostExecute(String result) {



            Log.e("Result22",result);

            //textView.setText(result);


            try {
                JSONObject jsonObject = new JSONObject(result);

                JSONObject jsonObject1 = jsonObject.getJSONObject("response");



                String keynamevalue = jsonObject1.getString("maxScore");
                String numfound = jsonObject1.getString("numFound");

                JSONArray jsonArray = jsonObject1.getJSONArray("docs");




                for (int i=0; i <=jsonArray.length();i++){




                    JSONObject jsonObject2 = jsonArray.getJSONObject(i);


                    String title_display = jsonObject2.getString("title_display");

                    list.add(title_display);


                    Log.e("jsonobject2", list.toString());

                  // textView.setText(list.toString());

                                    ArrayAdapter araylist = new ArrayAdapter(CheckConnection.this,R.layout.listitems,list);


                listView.setAdapter(araylist);

                }





            } catch (JSONException e) {
                e.printStackTrace();
            }



        }




    }




}

