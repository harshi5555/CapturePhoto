package com.example.harshi.capturephoto;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Bitmap bmp = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");
        setContentView(R.layout.activity_main2);
        ImageView viewBitmap = (ImageView)findViewById(R.id.imageView);
        viewBitmap.setImageBitmap(bmp);
    }
}
