package com.example.database.InsertData;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.database.utils.Utils;


public class MyDBHandler extends SQLiteOpenHelper {

    private Context context;
    SQLiteDatabase sqLiteDatabase;
    Activity activity;

    private static final String DATABASE_NAME = "contactmodel.db";
    private static final String TABLE_NAME = "contacts";
    private static final int DATABASE_VERSION = 4;

    private static final String UID = "id";
    private static final String FIRST_NAME = "First_Name";
    private static final String LAST_NAME = "Last_Name";


    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY, " + FIRST_NAME + " VARCHAR , " + LAST_NAME + " VARCHAR );";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public MyDBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

        Utils.show(context, "Constructor called");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);


        } catch (SQLException e) {

            Utils.show(context, "" + e);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Utils.show(context, "OnUpgrade called");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {

        }
    }


    public void addContacts(ContactModel contactModel) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(UID, contactModel.getID());
        contentValues.put(FIRST_NAME, contactModel.getFirstName());
        contentValues.put(LAST_NAME, contactModel.getLastName());

        sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();


    }


    ContactModel getContact(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContactModel contact = new ContactModel();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+"WHERE "+UID+"='"+id+"'", null);
        if (cursor != null) {
            cursor.moveToFirst();



            contact.setID(cursor.getInt(0));
            contact.setFirstName(cursor.getString(1));
            contact.setLastName(cursor.getString(2));
        }else{

        }


        return contact;
    }

//    public ContactModel findContact(String id ) {
//
//
//
//        String query = "Select * FROM " + TABLE_NAME +"WHERE "+UID+" = +id+"";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        Cursor cursor = db.rawQuery(query, null);
//
//        ContactModel model = new ContactModel();
//
//        if (cursor.moveToFirst()) {
//
//            model.setID(cursor.getInt(0));
//            model.setFirstName(cursor.getString(1));
//            model.setLastName(cursor.getString(2));
//
//
//        } else {
//            model = null;
//        }
//
//        return model;
//    }




}
