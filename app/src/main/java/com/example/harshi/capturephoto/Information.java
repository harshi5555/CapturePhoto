package com.example.harshi.capturephoto;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Information extends AppCompatActivity {
    final static int RESULT_OK =1;
    Bitmap bmp;

    String message =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setTitle("Information...");
        myToolbar.setLogo(R.drawable.logo);





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


                                EditText policy = (EditText)findViewById(R.id.editText4);
                                String poli = policy.getText().toString();
                                EditText date = (EditText)findViewById(R.id.editText5);
                                String dat = date.getText().toString();
                                EditText time = (EditText)findViewById(R.id.editText2);
                                String tim = time.getText().toString();
                                EditText location = (EditText)findViewById(R.id.editText6);
                                String loc = location.getText().toString();
                                EditText description = (EditText)findViewById(R.id.description);
                                String discrip = description.getText().toString();


                                message = "Policy Number :   " + poli + "\n" +"\n"+"What date did the incident occur ?   "+ dat +"\n"+ "\n"+"What date did the incident occur ?   " +tim+
                                "\n"+"\n"+ "Location of incident:   "  +loc +"\n" +"\n"+ "Vehicle damage details:   " + discrip ;

                                try {
                                    HandleNotification hn = new HandleNotification();
                                    StoreImages si = new StoreImages();

                                    startActivityForResult(Intent.createChooser(hn.sentEmail(message,si.saveBitmap(bmp, getExternalCacheDir()).getAbsolutePath()),
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
        if(resultCode==RESULT_OK)
            Log.d("test","test");
            Intent int2 = new Intent(this,Main3Activity.class);
            startActivity(int2);



    }
}









