package com.example.dogfinder;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class Analyze extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);

        Uri dog = getIntent().getParcelableExtra("dog");
        imageView = (ImageView) findViewById(R.id.userPic);
        imageView.setImageURI(dog);
    }
}
