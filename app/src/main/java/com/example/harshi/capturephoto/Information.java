package com.example.harshi.capturephoto;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Information extends AppCompatActivity {
    Bitmap bmp;
    EditText msg;
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bmp = (Bitmap) this.getIntent().getParcelableExtra("Bitmap");
        /*try{
        saveBitmap(bmp);
        }catch(Exception e)
        {
            //to complete
        }*/
        setContentView(R.layout.activity_main2);
        ImageView viewBitmap = (ImageView) findViewById(R.id.imageView);
        viewBitmap.setImageBitmap(bmp);


        Button sendEmail = (Button) findViewById(R.id.button);
        sendEmail.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                msg = (EditText) findViewById(R.id.editText2);
                final String message = msg.getText().toString();

                id = (EditText) findViewById(R.id.textId);
                final String cusId = id.getText().toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(Information.this);
                builder.setMessage("Do you want to proceed?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                HandleNotification hn = new HandleNotification();
                                try {
                                    StoreImages si = new StoreImages();
                                    startActivity(Intent.createChooser(hn.sentEmail(message, cusId, si.saveBitmap(bmp, getExternalCacheDir()).getAbsolutePath()), "Email"));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }


                            }
                        })
                        .setNegativeButton("Cancel", null);
                AlertDialog alert = builder.create();
                alert.show();
            }

        });

    }


}









