package com.example.harshi.capturephoto;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.location.Location;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;



import java.io.File;

public class Information extends AppCompatActivity  {

        final static int RESULT_OK = 1;
        Bitmap bmp;
        File file;
        Bundle myData;

    String message = null;
    Calendar c;
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_information);


            myData = getIntent().getExtras();


            c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            EditText dat = (EditText) findViewById(R.id.editText5);
            final String myDate = sdf.format(c.getTime());
            dat.setText(myDate);


            Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
            setSupportActionBar(myToolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle("My Claim");
                myToolbar.setLogo(R.drawable.logo);
                myToolbar.setTitleTextColor(android.graphics.Color.WHITE);



            }

file = (File)this.getIntent().getParcelableExtra("file");
            bmp = (Bitmap) this.getIntent().getParcelableExtra("Bitmap");

            ImageView viewBitmap = (ImageView) findViewById(R.id.imageView);
            viewBitmap.setImageBitmap(bmp);


            Button sendEmail = (Button) findViewById(R.id.button);
            sendEmail.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(Information.this);
                    builder.setMessage("Do you want to proceed?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @RequiresApi(api = Build.VERSION_CODES.N)
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Calendar c = Calendar.getInstance();
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


                                    EditText policy = (EditText) findViewById(R.id.editText4);
                                    String poli = policy.getText().toString();

                                    EditText location = (EditText) findViewById(R.id.editText6);
                                    String loc = location.getText().toString();
                                    EditText description = (EditText) findViewById(R.id.description);
                                    String discrip = description.getText().toString();




                                    message =    "\n" +"\n"+"Personal Number :   " + poli + "\n" + "\n" + "Date/Time :  " + sdf.format(c.getTime())+
                                            "\n" + "\n" + "Location of incident :   " + loc + "\n" + "\n" + "Vehicle damage details :   " + discrip;

                                    try {
                                        HandleNotification hn = new HandleNotification();
                                        StoreImages si = new StoreImages();
                                        startActivityForResult(Intent.createChooser(hn.sentEmail("       Customers' Details"+ "\n" + "\n"+  myData.getString("InsuaranceUserDetails") +"\n" + "\n"+ "         Customers' claim" + message, si.saveBitmap(bmp, getExternalCacheDir()).getAbsolutePath()),
                                                      "Email"), 1);
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

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (resultCode == RESULT_OK)
                Log.d("test", "test");
            Intent int2 = new Intent(this, LastPage.class);

            startActivity(int2);


        }
    }




