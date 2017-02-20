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
    String tex1, tex2, tex3, tex4, tex5, tex6, details;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

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
                                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);


                                //Inserts a String value into the mapping of this Bundle


                                save = (Button) findViewById(R.id.save);
                                String concatInfor = "Full Name : "         + te1.getText().toString() + "\n" +
                                                     "Policy Number  : "    + te2.getText().toString() + "\n" +
                                                     "Manfuacturer No  : "  + te3.getText().toString() + "\n" +
                                                     "Type   : "            + te4.getText().toString() + "\n" +
                                                     "Model  : "            + te5.getText().toString() + "\n" +
                                                     "Vehicle Number  : "   + te6.getText().toString() ;
                                myData.putString ("InsuaranceUserDetails",concatInfor);
                                intent.putExtras(myData);

                                startActivity(intent);

                                // writeToFile("hello");
                            }
                        })

                        .setNegativeButton("", null);
                AlertDialog alert = builder.create();

                alert.show();
            }



}




    /*
    public void AddData (){
        save.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(MyDetails.this);
                        builder.setMessage("You have successfully registered")
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {


                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {


                                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                                        //intent.putExtra("file", storeDetails());

                                        //Inserts a String value into the mapping of this Bundle
                                        te1 = (EditText) findViewById(R.id.fullName);
                                        te2 = (EditText) findViewById(R.id.policyNumber);
                                        te3 = (EditText) findViewById(R.id.manufactureYear);
                                        te4 = (EditText) findViewById(R.id.typeId);
                                        te5 = (EditText) findViewById(R.id.model);
                                        te6 = (EditText) findViewById(R.id.vehicleNumber);

                                        save = (Button) findViewById(R.id.save);
                                        boolean isInserted = userDbHelper.insertData(te1.getText().toString(), te2.getText().toString(), te3.getText().toString(),
                                                te4.getText().toString(), te5.getText().toString(), te6.getText().toString());

                                        if (isInserted = true)

                                            startActivity(intent);

                                        // writeToFile("hello");
                                    }
                                })

                                .setNegativeButton("", null);
                        AlertDialog alert = builder.create();

                        alert.show();

                    }



    });
}
*/

   /* public void write(View view) {
        String tex1 = te1.getText().toString();
        String tex2 = te2.getText().toString();
        String tex3 = te3.getText().toString();
        String tex4 = te4.getText().toString();
        String tex5 = te5.getText().toString();
        String tex6 = te6.getText().toString();

        String myDetail= tex1+tex2+tex3+tex4+tex5+tex6;

        try {
            FileOutputStream fileOutputStream = openFileOutput("myText.txt",MODE_PRIVATE);
            fileOutputStream.write(myDetail.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"Text Saved",Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public File storeDetails() {
        File file = null;


        try {


            file = File.createTempFile("informaiton", ".txt", getExternalCacheDir());
            FileOutputStream out = new FileOutputStream(file);
            JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.setIndent("  ");
            writer.beginObject();
            writer.name("fullName").value(R.id.fullName);
            writer.name("policyNumber").value(R.id.policyNumber);
            writer.name("manufactureYear").value(R.id.manufactureYear);
            writer.name("typeId").value(R.id.typeId);
            writer.name("model").value(R.id.model);
            writer.name("vehicleNumber").value(R.id.vehicleNumber);
            writer.close();
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println(file.getAbsolutePath());


        return file;
    }*/


   /* private void details(String s) {
    }

    private void writeToFile(String myData) {
        String tex1 = te1.getText().toString();
        String tex2 = te2.getText().toString();
        String tex3 = te3.getText().toString();
        String tex4 = te4.getText().toString();
        String tex5 = te5.getText().toString();
        String tex6 = te6.getText().toString();

        String myData1= tex1+tex2+tex3+tex4+tex5+tex6;

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("customer.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(myData.getBytes());
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/









