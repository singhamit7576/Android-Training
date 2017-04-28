package com.example.contentprovidertest.Ui.CustomContentProvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;


public class BooksProvider extends ContentProvider {

    public static final String AUTHORITY = "com.contantprovider.Books";
    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/books");
    public static final String ID = "_id";
    public static final String TITLE = "title";
    public static final String ISBN = "isbn";
    private static final int BOOKS = 1;
    private static final int BOOK_ID = 2;
    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "books", BOOKS);
        uriMatcher.addURI(AUTHORITY, "books/#", BOOK_ID);
    }

    //---for database use---
    private SQLiteDatabase sqLiteDatabase;

    private static final String DATABASE_NAME = "Books";
    private static final String DATABASE_TABLE = "titles";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE =
            "create table " + DATABASE_TABLE +
                    " (_id integer primary key autoincrement, "
                    + "title text not null, isbn text not null);";

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS titles");
            onCreate(db);
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case BOOKS:
                count = sqLiteDatabase.delete(
                        DATABASE_TABLE,
                        selection,
                        selectionArgs);
                break;
            case BOOK_ID:
                String id = uri.getPathSegments().get(1);
                count = sqLiteDatabase.delete(
                        DATABASE_TABLE,
                        ID + " = " + id +
                                (!TextUtils.isEmpty(selection) ? " AND (" +
                                        selection + ')' : ""),
                        selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);

        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            //---get all books---
            case BOOKS:
                return "vnd.android.cursor.dir/vnd.contantprovider.books ";
            //---get a particular book---
            case BOOK_ID:
                return "vnd.android.cursor.item/vnd.contantprovider.books ";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        long rowID = sqLiteDatabase.insert(DATABASE_TABLE, "", values);
        //---if added successfully---
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        return uri;
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        return (sqLiteDatabase == null) ? false : true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder sqlBuilder = new SQLiteQueryBuilder();
        sqlBuilder.setTables(DATABASE_TABLE);
        if (uriMatcher.match(uri) == BOOK_ID)
            //---if getting a particular book---
            sqlBuilder.appendWhere(

                    ID + " = " + uri.getPathSegments().get(1));
        if (sortOrder == null || sortOrder == "")
            sortOrder = TITLE;
        Cursor cursor = sqlBuilder.query(sqLiteDatabase, projection, selection, selectionArgs, null, null, sortOrder);
        //---register to watch a content URI for changes---
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case BOOKS:
                count = sqLiteDatabase.update(DATABASE_TABLE,
                        values,
                        selection,
                        selectionArgs);
                break;

            case BOOK_ID:
                count = sqLiteDatabase.update(
                        DATABASE_TABLE,
                        values,
                        ID + " = " + uri.getPathSegments().get(1) +
                                (!TextUtils.isEmpty(selection) ? " AND (" +
                                        selection + ')' : ""),
                        selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}

