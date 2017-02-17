package com.example.harshi.capturephoto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.JsonWriter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MyDetails extends AppCompatActivity implements View.OnClickListener {
    Button save;
    EditText te1, te2, te3, te4, te5, te6;
    String tex1, tex2, tex3, tex4, tex5, tex6, details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_details);
        findAllViewsId ();
        save.setOnClickListener (this);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Details");
            myToolbar.setLogo(R.drawable.logo);




        }


    }

    private void findAllViewsId() {
        te1 = (EditText) findViewById(R.id.fullName);
        te2 = (EditText) findViewById(R.id.policyNumber);
        te3 = (EditText) findViewById(R.id.manufactureYear);
        te4 = (EditText) findViewById(R.id.typeId);
        te5 = (EditText) findViewById(R.id.model);
        te6 = (EditText) findViewById(R.id.vehicleNumber);

        save = (Button) findViewById(R.id.save);}








    public File storeDetails() {
        File file = null;
        try {
            file = File.createTempFile("informaiton.txt", ".txt", getExternalCacheDir());
            FileOutputStream out = new FileOutputStream(file);
            JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.setIndent("  ");
            writer.beginObject();
            writer.name("vehicleNumber").value(R.id.fullName);
            writer.name("vehicleNumber").value(R.id.policyNumber);
            writer.name("vehicleNumber").value(R.id.manufactureYear);
            writer.name("vehicleNumber").value(R.id.typeId);
            writer.name("vehicleNumber").value(R.id.model);
            writer.name("vehicleNumber").value(R.id.vehicleNumber);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return file;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), CustomerDetail.class);
        //Create a bundle object
        Bundle b = new Bundle();

        //Inserts a String value into the mapping of this Bundle
        b.putString("name",te1.getText().toString());
        b.putString("policy", te2.getText().toString());
        b.putString("year",te3.getText().toString());
        b.putString("type", te4.getText().toString());
        b.putString("model",te5.getText().toString());
        b.putString("vehNo", te6.getText().toString());





        //Add the bundle to the intent.
        intent.putExtras(b);

        //start the DisplayActivity
        startActivity(intent);
    }
}



