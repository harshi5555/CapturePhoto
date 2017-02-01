package com.example.harshi.capturephoto;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Bitmap bmp;
    EditText msg;
    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bmp = (Bitmap) this.getIntent().getParcelableExtra("Bitmap");
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
                        .setPositiveButton("Ok",new DialogInterface.OnClickListener(){


                            @Override
                            public void onClick(DialogInterface dialog, int which) {



                            String[] to = new String[]{"harshi5555@gmail.com"};
                String subject = (" Details for the insurance claim! \n Customer Id: " + cusId);
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT,message);
                emailIntent.setType("message/rfc822");
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




    }









