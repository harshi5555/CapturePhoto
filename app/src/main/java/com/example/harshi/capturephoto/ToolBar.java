package com.example.harshi.capturephoto;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
/**
 * Created by harshi on 14/02/17.
 */

public class ToolBar extends AppCompatActivity {

    public Toolbar getMyToolbar( ) {

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle("alianz..");
            myToolbar.setLogo(R.drawable.logo);



        }

        return myToolbar;
    }
}
