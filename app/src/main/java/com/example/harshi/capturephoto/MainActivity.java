package com.example.harshi.capturephoto;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonS;
    Button buttonCap;
    ImageView image;
    Intent i;
    final static int CAMERA_DATA = 0;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }
    private void initialize(){
        buttonS =(Button)findViewById(R.id.buttonSend);
        buttonCap=(Button)findViewById(R.id.buttonTakePic);
        image=(ImageView)findViewById(R.id.photo);
        buttonCap.setOnClickListener(this);
        buttonS.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonSend:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Main2Activity.class);
                    intent.putExtra("Bitmap",bmp);
                startActivity(intent);
             break;
            case R.id.buttonTakePic:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(i,CAMERA_DATA);
                break;

        }

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
           image.setImageBitmap(bmp);

        }





    }




    }

