package com.example.dogfinder;

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
        takePictureButton = (ImageButton) findViewById(R.id.back);
    }

    public void backHome(View view) {
        Intent backHome = new Intent(this, MainActivity.class);
        startActivity(backHome);
    }
}
