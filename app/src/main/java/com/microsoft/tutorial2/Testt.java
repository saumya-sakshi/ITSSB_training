package com.microsoft.tutorial2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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

import Models.Plos;

public class Testt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testt);


        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();


        connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);


        if (networkInfo != null && networkInfo.isConnected()) {

            Log.e("Status", "INternet Connected");

        new JSonTask().execute();


            // Create background thread to connect and get data
            //new DownloadWebpageTask().execute(stringUrl);
        } else {

            Log.e("Status", "NO Internet Connection available");
            //textView.setText("No network connection available.");
        }
    }


    public static class JSonTask extends AsyncTask<String, String, JSONObject> {


        @Override
        protected void onPreExecute() {
            Log.e("status", "came inside");
            super.onPreExecute();
        }

        JSONObject jsonObject;
        @Override
        protected JSONObject doInBackground(String... params) {

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
                String FinalJson = buffer.toString();

                jsonObject = new JSONObject(FinalJson);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject;

        }


        @Override
        protected void onPostExecute(JSONObject jsonObject) {


 if (jsonObject!=null){


     ArrayList<Plos> arrayList = new ArrayList<>();

     try {
         JSONObject jsonObject1 = jsonObject.getJSONObject("response");
         String num = jsonObject1.getString("numFound");

         JSONArray jsonArray = jsonObject1.getJSONArray("docs");

         //Plos plos = new Plos();
         for (int i=0; i <=jsonArray.length();i++){
                 JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                 Plos plos = new Plos(jsonObject2.getString("publication_date"),jsonObject2.getString("eissn"));
                 arrayList.add(plos);
               //  jsonObject2.get()
                 //arrayList.add(new Plos(jsonObject2.get("id").toString()));
             Log.e("arrayvalue",jsonObject2.getString("eissn"));
             Log.e("arrayvalue",jsonObject2.getString("publication_date"));
         }



         Log.e("Value",num);
     } catch (JSONException e) {
         e.printStackTrace();
     }


 }
         }
    }
}
