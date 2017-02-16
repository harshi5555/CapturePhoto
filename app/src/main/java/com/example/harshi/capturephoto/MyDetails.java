package com.example.harshi.capturephoto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

public class MyDetails extends AppCompatActivity {
    Button save;
    EditText te1, te2, te3, te4, te5, te6;
    String tex1, tex2, tex3, tex4, tex5, tex6, details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_details);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Details");
            myToolbar.setLogo(R.drawable.logo);



        te1 = (EditText) findViewById(R.id.fullName);
        String tex1 = te1.getText().toString();
        te2 = (EditText) findViewById(R.id.policyNumber);
        String tex2 = te2.getText().toString();
        te3 = (EditText) findViewById(R.id.manufactureYear);
        String tex3 = te3.getText().toString();
        te4 = (EditText) findViewById(R.id.typeId);
        String tex4 = te4.getText().toString();
        te5 = (EditText) findViewById(R.id.model);
        String tex5 = te5.getText().toString();
        te6 = (EditText) findViewById(R.id.vehicleNumber);
        String tex6 = te6.getText().toString();
        save = (Button) findViewById(R.id.save);


        details = tex1 + tex2+tex3+tex4+tex5+tex6;



        }

    }
}
