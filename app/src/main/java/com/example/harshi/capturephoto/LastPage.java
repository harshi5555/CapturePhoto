package com.example.harshi.capturephoto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LastPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Alianz Insurance");
            myToolbar.setLogo(R.drawable.logo);
            myToolbar.setTitleTextColor(android.graphics.Color.WHITE);
        }

        Button btn = (Button)findViewById(R.id.home);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(LastPage.this,MenuActivity.class);
                startActivity(int3);
            }
        });
    }

}
