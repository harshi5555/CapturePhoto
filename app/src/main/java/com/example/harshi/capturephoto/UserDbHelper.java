package com.example.harshi.capturephoto;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by harshi on 19/02/17.
 */

public class UserDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "USERINFO.DB";
    public static final String TABLE_NAME = "Customer_details";
    public static final String COL_1 ="NAME";
    public static final String COL_2  ="POLICYNO";
    public static final String COL_3  ="MANUYEAR";
    public static final String COL_4  ="VEHTYPE";
    public static final String COL_5  ="MODEL";
    public static final String COL_6 ="VEHNUM";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);


    }









    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +"(NAME TEXT ,POLICYNO TEXT,MANUYEAR TEXT,VEHTYPE TEXT,MODEL TEXT,VEHNUM TEXT)");
        System.out.println("SSSSSSSSSSSSSSS");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);


        onCreate(db);
    }


    public boolean insertData(String name,String policy,String manufacute, String type,String model, String vehicleNo){

       SQLiteDatabase db = getWritableDatabase(); {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_1,name);
            contentValues.put(COL_2,policy);
            contentValues.put(COL_3,manufacute);
            contentValues.put(COL_4,type);
            contentValues.put(COL_5,model);
            contentValues.put(COL_6,vehicleNo);
            long result =db.insert(TABLE_NAME,null,contentValues);

            if(result==-1)
                return  false;
            else
                return  true;

        }
    }


}
