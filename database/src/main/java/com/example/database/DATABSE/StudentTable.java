package com.example.database.DATABSE;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.database.utils.Utils;

/**
 * Created by user on 17/4/17.
 */
public class StudentTable {

    Student student = new Student() ;
    Context context ;
    public static final String STUDENT_TABLE_NAME = "student";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_FNAME = "fathername";
    private static final String KEY_ADDRESS = "address";
    private int id ;
    private  String name ,fname , address;
    private String TAG = this.getClass().getSimpleName();
    private SQLiteDatabase sqLiteDatabase = null ;

    public  static  String CREATE_TABLE = "CREATE TABLE " + STUDENT_TABLE_NAME + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
            + KEY_FNAME + " TEXT," + KEY_ADDRESS + " TEXT" + ")";

    public  StudentTable(Context context, Student student){
        this.context = context ;
        this.student =student ;
    }

    public StudentTable(Context context) {
        this.context =context;
    }

    public void insertData(){

        if(sqLiteDatabase == null){
            return ;
        }

        id        =  student .getId() ;
        name      =  student .getName() ;
        fname     =  student .getLastname() ;
        address   =  student .getAddress() ;
        String QUERY = "insert into "+ STUDENT_TABLE_NAME + "(id,name,fathername,address) values ('" +id +"','"+ name +"','"+fname+"' ,'"+address + "')" ;

        sqLiteDatabase.execSQL(QUERY);

    }
    public  void openConnection(){

        sqLiteDatabase = new MyHelperClass(context, DatabaseConstant.DBNAME , null, DatabaseConstant.VERSION).getReadableDatabase();

        Utils.printLog(TAG ,"outside openConnection");
    }

    public void closeConeection(){
        if(sqLiteDatabase != null && sqLiteDatabase.isOpen()) {
            sqLiteDatabase.close();
        }
    }

    public Student retriveData(String id){

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM student WHERE id='"+id+"'", null);
        if(cursor.moveToFirst())
        {
            // Displaying record if found
            student.setId(cursor.getInt(0));
            student.setName(cursor.getString(1));
            student.setLastname(cursor.getString(2));
            student.setAddress(cursor.getString(3));
        }
        else
        {

        }
        return student;
    }

    public void updateData(String id2){
        // Searching roll number
        Cursor c=sqLiteDatabase.rawQuery("SELECT * FROM student WHERE id='"+id2+"'", null);
        if(c.moveToFirst())
        {
            // Modifying record if found
            sqLiteDatabase.execSQL("UPDATE student SET name='"+"surya"+"',address='"+"jharkhand"+
                    "' WHERE id='"+id2+"'");

        }
        else
        {

        }

    }

    public void deleteData(String id){
        // Searching roll number
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM student WHERE id='"+ id +"'", null);
        if(c.moveToFirst())
        {

            sqLiteDatabase.execSQL("DELETE FROM student WHERE id='"+id+"'");

        }
        else
        {

        }
    }

    public String viewAll(){
        // Retrieving all records
        Cursor c=sqLiteDatabase.rawQuery("SELECT * FROM student", null);
        // Checking if no records found
        if(c.getCount()==0)
        {
            Utils.show(context, "No records found");
            return "";
        }
        // Appending records to a string buffer
        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append("id: "+c.getString(0)+"\n");
            buffer.append("Name: "+c.getString(1)+"\n");
            buffer.append("lastname: "+c.getString(2)+"\n\n");
            buffer.append("address: "+c.getString(3)+"\n\n");
        }
        return String.valueOf(buffer);
    }
}
