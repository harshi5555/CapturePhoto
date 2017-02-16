package com.example.harshi.capturephoto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.view.View;



public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Alianz Insurance");
            myToolbar.setLogo(R.drawable.logo);
        }


        Button button = (Button) findViewById(R.id.inClaim);
        button.setOnClickListener(this);

      button1 = (Button) findViewById(R.id.myDetail);
        button1.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.inClaim:
                Intent intent = new Intent(MenuActivity.this, CaptureCamera.class);
                startActivity(intent);
                break;
        }

        switch (view.getId()) {
            case R.id.myDetail:
                Intent intent1 = new Intent(MenuActivity.this, MyDetails.class);
                startActivity(intent1);
                break;


        }

    }
}













