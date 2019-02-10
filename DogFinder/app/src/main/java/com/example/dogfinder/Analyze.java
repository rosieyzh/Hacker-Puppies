package com.example.dogfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageButton;
import org.tensorflow.lite.Interpreter;
import java.nio.MappedByteBuffer;
import java.io.IOException;
import android.content.res.AssetFileDescriptor;
import java.nio.channels.FileChannel;
import java.io.FileInputStream;
import android.app.Activity;


public class Analyze extends AppCompatActivity {
    private ImageView imageView;

    private Uri bmpUri;

    private ImageButton takePictureButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);

        bmpUri = getIntent().getParcelableExtra("dog");
        imageView = (ImageView) findViewById(R.id.userPic);

        imageView.setImageURI(bmpUri);


        takePictureButton = (ImageButton) findViewById(R.id.Analysis);

    }

    public void swapLoading(View view) {
        /*String modelFile="model.lite";
        Interpreter tflite;

        try {
            tflite=new Interpreter(loadModelFile(Analyze.this,modelFile));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Intent swapLoad = new Intent(this, LoadingScreen.class);
        swapLoad.putExtra("dog", bmpUri);
        startActivity(swapLoad);

    }

    /*private MappedByteBuffer loadModelFile(Activity activity,String MODEL_FILE) throws IOException {
        AssetFileDescriptor fileDescriptor = activity.getAssets().openFd(MODEL_FILE);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }
    */


}
