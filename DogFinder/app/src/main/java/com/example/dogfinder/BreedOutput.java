package com.example.dogfinder;


import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class BreedOutput extends AppCompatActivity {
    private Uri bmpUri;
    private ImageView imageView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BreedOutput extends AppCompatActivity {
    private ImageButton takePictureButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_output);


        bmpUri = getIntent().getParcelableExtra("dog");
        imageView = (ImageView) findViewById(R.id.finalDog);
        imageView.setImageURI(bmpUri);

        takePictureButton = (ImageButton) findViewById(R.id.back);
    }

    public void backHome(View view) {
        Intent backHome = new Intent(this, MainActivity.class);
        startActivity(backHome);

    }
}
