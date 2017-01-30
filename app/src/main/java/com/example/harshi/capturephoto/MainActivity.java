package com.example.harshi.capturephoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonS;
    Button buttonCap;
    ImageView image;
    Intent i;
    final static int CAMARA_DATA = 0;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
        bmp= BitmapFactory.decodeStream(is);

    }
    private void initialize(){
        buttonS =(Button)findViewById(R.id.buttonSend);
        buttonCap=(Button)findViewById(R.id.buttonTakePic);
        image=(ImageView)findViewById(R.id.photo);
        buttonCap.setOnClickListener(this);
        buttonS.setOnClickListener(this);

    }

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
                startActivityForResult(i,CAMARA_DATA);
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
