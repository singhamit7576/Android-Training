package com.example.database.CreateDataBase;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.database.utils.Utils;


public class InfoDataBase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME =     "infodatabse.db";
    private static final String TABLE_NAME    =     "INFODATA";
    private static final int DATABASE_VERSION =      2;
    private static final String UID           =     "_id";
    private static final String NAME          =     "Name";
    private static final String CREATE_TABLE  =     "CREATE TABLE "+TABLE_NAME+" " +
                                                    "("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME +" VARCHAR);";
    private static final String DROP_TABLE    =     "DROP TABLE IF EXISTS "+TABLE_NAME;


    public InfoDataBase(Context context) {

        super(context, DATABASE_NAME,null,DATABASE_VERSION);
       // this.context = context;
        Utils.show(context,"Constructor called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Utils.show(context,"Oncreate called");
        try {
            db.execSQL(CREATE_TABLE);


        }catch (SQLException e){

            Utils.show(context,""+e);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Utils.show(context,"OnUpgrade called");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch(SQLException e)
        {

        }

    }
}
