package com.example.harshi.capturephoto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class CustomerDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_detail);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setTitle("Alianz Insurance");
        myToolbar.setLogo(R.drawable.logo);


        Bundle b = getIntent().getExtras();
        TextView name = (TextView) findViewById(R.id.fullName);
        TextView policy = (TextView) findViewById(R.id.policyNumber);
        TextView year = (TextView) findViewById(R.id.manufactureYear);
        TextView type = (TextView) findViewById(R.id.typeId);
        TextView model = (TextView) findViewById(R.id.model);
        TextView vehNo = (TextView) findViewById(R.id.vehicleNumber);

        name.setText(b.getCharSequence("name"));
        policy.setText(b.getCharSequence("policy"));
        year.setText(b.getCharSequence("year"));
        type.setText(b.getCharSequence("type"));
        model.setText(b.getCharSequence("model"));
        vehNo.setText(b.getCharSequence("vehno"));



    }
}
