package com.example.harshi.capturephoto;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * Created by harshi on 07/02/17.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class HandleNotification extends AppCompatActivity {
    String claim;


    public Intent sentEmail(String message,String path){
        String[] to = new String[]{"harshi5555@gmail.com"};
        String subject = (" Details of the accident claim!");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + path));
        emailIntent.putExtra(Intent.EXTRA_TEXT,message);
        emailIntent.setType("image/jpeg");
        return emailIntent;
    }


    public Intent sentEmail(String claim){
        this.claim=claim;
        String[] to = new String[]{"harshi5555@gmail.com"};
        String subject = (" Details of the accident claim!");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT,claim );
        emailIntent.setType("text/plain");
        return emailIntent;
    }




}
