package com.example.harshi.capturephoto;

import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by harshi on 07/02/17.
 */

public class StoreImages {
    public File saveBitmap(Bitmap bitmap,File dir) throws Exception{
        File file = null;
        if (bitmap != null) {
            file = File.createTempFile("image",".bmp",dir);
            try {
                FileOutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(file.getAbsoluteFile());

                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
