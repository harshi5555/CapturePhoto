package com.example.harshi.capturephoto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;


public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1,button2;
    Bundle myData;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);




       Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("EasyClaim");
            myToolbar.setLogo(R.drawable.logo);
            myToolbar.setTitleTextColor(android.graphics.Color.WHITE);

        }


        Button button = (Button) findViewById(R.id.inClaim);
        button.setOnClickListener(this);

        button1 = (Button) findViewById(R.id.myDetail);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.stolen);
        button2.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.myicon){

            Intent intent = new Intent(MenuActivity.this,BasicInfor.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.inClaim:
                myData = getIntent().getExtras();
                Intent intent = new Intent(MenuActivity.this, CaptureCamera.class);

                if(myData != null){
                    intent.putExtras(myData);

                }
                startActivity(intent);
                break;
        }

        switch (view.getId()) {
            case R.id.myDetail:
                Intent intent1 = new Intent(MenuActivity.this, MyDetails.class);
                startActivity(intent1);
                break;
        }
            switch (view.getId()) {
                case R.id.stolen:
                    myData = getIntent().getExtras();
                    Intent myIntent = new Intent(MenuActivity.this, TheftClaim.class);
                    if(myData != null){
                        final Intent intent = myIntent.putExtras(myData);

                    }
                    startActivity(myIntent);


                    break;
            }

        }
    }














