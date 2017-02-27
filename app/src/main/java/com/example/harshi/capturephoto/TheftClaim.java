package com.example.harshi.capturephoto;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TheftClaim extends AppCompatActivity {
    String[] to = new String[]{"harshi5555@gmail.com"};
    String subject = (" Details of the accident claim!");
    String claim;
    Bundle myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theft_claim);

        initialize();
        myData = getIntent().getExtras();
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Theft Claim");
            myToolbar.setLogo(R.drawable.logo);
            myToolbar.setTitleTextColor(android.graphics.Color.WHITE);

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);


        }
    }

    private void initialize() {




        Button sendEmail = (Button) findViewById(R.id.button);
        sendEmail.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(TheftClaim.this);
                builder.setMessage("Do you want to proceed?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText date = (EditText) findViewById(R.id.date);
                                String datTim = date.getText().toString();
                                EditText location = (EditText) findViewById(R.id.place);
                                String pla = location.getText().toString();
                                EditText discover = (EditText) findViewById(R.id.discover);
                                String discov = discover.getText().toString();
                                EditText person = (EditText) findViewById(R.id.name);
                                String pers = person.getText().toString();
                                EditText describe = (EditText) findViewById(R.id.description1);
                                String descri = describe.getText().toString();

                             




                                claim = "\n" + "\n" + "Date/Time vehicle was last seen :   " + datTim+ "\n" + "\n" + "Place vehicle was last seen :   " +pla+
                                        "\n" + "\n" + "Date/damage was discovered :   " + discov + "\n" + "\n" + "Name of last person in charge :   " + pers+ "\n" + "\n" +
                                        "If Known,describe how the vehicle was stolen : "+ descri + "\n" + "\n"  ;

                                try {
                                    HandleNotification hn = new HandleNotification();
                                    if(myData!= null)
                                     startActivityForResult(Intent.createChooser(hn.sentEmail("       Customers' Details"+ "\n" + "\n"+ myData.getString("InsuaranceUserDetails") +  "\n"+"\n" + "\n"+ "         Customers' claim" + claim),"Email"), 1);
                                    else
                                        startActivityForResult(Intent.createChooser(hn.sentEmail(claim),"Email"), 1);

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
        super.onActivityResult(requestCode, resultCode, data);
        Intent int3 = new Intent(this , LastPage.class);
        startActivity(int3);
     }
}