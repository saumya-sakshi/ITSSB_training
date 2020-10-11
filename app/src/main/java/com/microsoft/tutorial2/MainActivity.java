package com.microsoft.tutorial2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity  {


ImageView imageView;

VideoView videoView;
Button videobtn;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_VIDEO_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);

        imageView.setImageResource(R.drawable.download);
        videobtn = (Button)findViewById(R.id.video);
videoView = (VideoView)findViewById(R.id.videoView);

videobtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        dispatchTakeVideoIntent();
    }
});
        if (savedInstanceState != null) {
            String count = savedInstanceState.getString("count");
         Log.e("Count value",count);
        }


        final EditText Name = (EditText)findViewById(R.id.namefield);
        Button btn = (Button)findViewById(R.id.button);
        final TextView txt = (TextView)findViewById(R.id.textView);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this,Page2.class);


                String countryname = "Norway";
                intent.putExtra("rollno", "45");
                intent.putExtra("rollno1", "45");
                intent.putExtra("rollno2", "45");
                intent.putExtra("rollno3", "45");
                intent.putExtra("country",countryname);
                startActivity(intent);


//
//                Uri uri = Uri.parse("tel:8005551234");
//                Intent it = new Intent(Intent.ACTION_DIAL, uri);
//                startActivity(it);

//
//                Uri uri = Uri.parse("http://www.google.com");
//                Intent it = new Intent(Intent.ACTION_VIEW,uri);
//                startActivity(it);


//                Intent intent =new Intent(MainActivity.this,Page2.class);
//
//                intent.putExtra("K","kkk");
//                startActivity(intent);
//                Log.e("status", "Button Clicked");
//                txt.setText("Welcome to  " +Name.getText().toString());

            }
        });


//        dispatchTakePictureIntent();
    }

    private void dispatchTakeVideoIntent() {


        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
            videoView.setVideoURI(videoUri);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Add information for saving HelloToast counter
        // to the to the outState bundle
        outState.putString("count", "VV");


    }


}
