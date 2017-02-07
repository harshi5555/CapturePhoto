package com.example.harshi.capturephoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by harshi on 07/02/17.
 */

public class HandleNotification extends AppCompatActivity {
    public Intent sentEmail(String message,String cusId,String path){
        String[] to = new String[]{"harshi5555@gmail.com"};
        String subject = (" Details of the insurance claim! \n Customer Id: " + cusId);
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT,message);
        //try{
            //String path = saveBitmap(bmp).getAbsolutePath();
            emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + path));

        //}catch(Exception e)
        //{
          //  e.printStackTrace();
        //}
        emailIntent.setType("image/jpeg");

        return emailIntent;
        //startActivity(Intent.createChooser(emailIntent,"Email"));
    }


}
