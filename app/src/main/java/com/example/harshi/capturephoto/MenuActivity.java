package com.example.harshi.capturephoto;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MenuActivity extends AppCompatActivity {
     CircleMenu circleMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        circleMenu =(CircleMenu)findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#575BFB"),R.drawable.menu,R.drawable.cancel);
        circleMenu.addSubMenu(Color.parseColor("#575BFB"),R.drawable.car)
        .addSubMenu(Color.parseColor("#575BFB"),R.drawable.driver)
                .addSubMenu(Color.parseColor("#575BFB"),R.drawable.id)
                .addSubMenu(Color.parseColor("#575BFB"),R.drawable.insurance)
                .addSubMenu(Color.parseColor("#575BFB"),R.drawable.pay)
                .addSubMenu(Color.parseColor("#575BFB"),R.drawable.information);



        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

                                                 @Override
                                                 public void onMenuSelected(int index) {
                                                     switch (index) {
                                                         case 0:
                                                             Intent intent = new Intent(MenuActivity.this,CaptureCamera.class);
                                                             startActivity(intent);
                                                             break;
                                                         case 1:
                                                             Toast.makeText(MenuActivity.this, "Search button Clicked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 2:
                                                             Toast.makeText(MenuActivity.this, "Notify button Clciked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 3:
                                                             Toast.makeText(MenuActivity.this, "Settings button Clcked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 4:
                                                             Toast.makeText(MenuActivity.this, "GPS button Clicked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                     }




                                                 }
                                             }

        );

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setTitle("iiii");
        myToolbar.setLogo(R.drawable.logo);


    }
}
