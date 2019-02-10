package com.example.dogfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.net.Uri;
import android.widget.ImageView;
import android.graphics.Bitmap;
import 	android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import android.util.Log;

public class Analyze extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);

        imageView = (ImageView) findViewById(R.id.dog);
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("picture");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        imageView.setImageBitmap(bmp);



    }
}
