package com.example.database.DATABSE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.database.utils.Utils;


public class MyHelperClass extends SQLiteOpenHelper {

    private Context context ;
    private String TAG = this.getClass().getSimpleName();

    public MyHelperClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Utils.printLog(TAG ,"inside onCreate ()");
        db.execSQL(StudentTable.CREATE_TABLE);
        Utils.show(context ,"table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + StudentTable.STUDENT_TABLE_NAME);
        // db.execSQL("DROP table student");
        db.execSQL(StudentTable.CREATE_TABLE);
    }



}
