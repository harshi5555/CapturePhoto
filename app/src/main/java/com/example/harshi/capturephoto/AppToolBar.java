package com.example.harshi.capturephoto;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
/**
 * Created by harshi on 14/02/17.
 */

public class AppToolBar extends AppCompatActivity {

    String toolBarTitle;
    public AppToolBar(String toolBarTitle){
        this.toolBarTitle = toolBarTitle;
    }
    public Toolbar getMyToolbar() {

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle(toolBarTitle);
            myToolbar.setLogo(R.drawable.logo);
            myToolbar.setTitleTextColor(android.graphics.Color.WHITE);



        }
        return myToolbar;

    }

}
