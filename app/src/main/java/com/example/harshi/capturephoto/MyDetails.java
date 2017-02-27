package com.example.harshi.capturephoto;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyDetails extends AppCompatActivity implements View.OnClickListener {
    Button save;
    EditText te1, te2, te3, te4, te5, te6;
    UserDbHelper userDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_details);
        findAllViewsId();
        save.setOnClickListener(this);
        userDbHelper = new UserDbHelper(this);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Details");
            myToolbar.setLogo(R.drawable.logo);
            myToolbar.setTitleTextColor(android.graphics.Color.WHITE);

        }


    }

    private void findAllViewsId() {
        te1 = (EditText) findViewById(R.id.fullName);
        te2 = (EditText) findViewById(R.id.policyNumber);
        te3 = (EditText) findViewById(R.id.manufactureYear);
        te4 = (EditText) findViewById(R.id.typeId);
        te5 = (EditText) findViewById(R.id.model);
        te6 = (EditText) findViewById(R.id.vehicleNumber);

        save = (Button) findViewById(R.id.save);
    }




            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MyDetails.this);
                builder.setMessage("You have successfully registered")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {


                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                 Bundle myData = new Bundle();
                                save = (Button) findViewById(R.id.save);
                                Intent intent = new Intent(MyDetails.this,MenuActivity.class);


                                //Inserts a String value into the mapping of this Bundle


                                save = (Button) findViewById(R.id.save);
                                String concatInfor = "Full Name : "         + te1.getText().toString() + "\n" +
                                                     "Policy Number  : "    + te2.getText().toString() + "\n" +
                                                     "Manufacture year  : "  + te3.getText().toString() + "\n" +
                                                     "Type   : "            + te4.getText().toString() + "\n" +
                                                     "Model  : "            + te5.getText().toString() + "\n" +
                                                     "Vehicle Number  : "   + te6.getText().toString() ;
                                myData.putString ("InsuaranceUserDetails",concatInfor);
                                intent.putExtras(myData);

                                startActivity(intent);


                            }
                        })

                        .setNegativeButton("", null);
                AlertDialog alert = builder.create();

                alert.show();
            }



}




