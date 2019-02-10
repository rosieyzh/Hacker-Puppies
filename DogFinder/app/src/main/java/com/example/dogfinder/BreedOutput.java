package com.example.dogfinder;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class BreedOutput extends AppCompatActivity {
    private Uri bmpUri;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_output);

        bmpUri = getIntent().getParcelableExtra("dog");
        imageView = (ImageView) findViewById(R.id.finalDog);
        imageView.setImageURI(bmpUri);
    }
}
