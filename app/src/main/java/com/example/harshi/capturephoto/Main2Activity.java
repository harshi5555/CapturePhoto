package com.example.harshi.capturephoto;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Main2Activity extends AppCompatActivity {
    Bitmap bmp;
    EditText msg;
    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bmp = (Bitmap) this.getIntent().getParcelableExtra("Bitmap");
        try{
        saveBitmap(bmp);
        }catch(Exception e)
        {

        }
        setContentView(R.layout.activity_main2);
        ImageView viewBitmap = (ImageView) findViewById(R.id.imageView);
        viewBitmap.setImageBitmap(bmp);




        Button sendEmail = (Button) findViewById(R.id.button);
        sendEmail.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                msg =(EditText)findViewById(R.id.editText2);
                final String message =msg.getText().toString();

                id =(EditText)findViewById(R.id.textId);
                final String cusId =id.getText().toString();



                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setMessage("Do you want to proceed?")
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener(){


                            @Override
                            public void onClick(DialogInterface dialog, int which) {



                            String[] to = new String[]{"harshi5555@gmail.com"};
                String subject = (" Details of the insurance claim! \n Customer Id: " + cusId);
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT,message);
                try{
                    String path = saveBitmap(bmp).getAbsolutePath();
                    emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + path));

                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                emailIntent.setType("image/jpeg");


                startActivity(Intent.createChooser(emailIntent,"Email"));
                Toast.makeText(getApplicationContext(), "send", Toast.LENGTH_LONG).show();
                            }
                        })
                  .setNegativeButton("Cancel",null);
                AlertDialog alert =builder.create();
                alert.show();
            }

        });

    }

    private File saveBitmap(Bitmap bitmap) throws Exception{
        File file = null;
        if (bitmap != null) {
            file = File.createTempFile("image",".bmp",getExternalCacheDir());
                try {
                FileOutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(file.getAbsoluteFile());

                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }


    }









