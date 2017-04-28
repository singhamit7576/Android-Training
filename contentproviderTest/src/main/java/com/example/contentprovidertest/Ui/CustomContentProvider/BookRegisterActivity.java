package com.example.contentprovidertest.Ui.CustomContentProvider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.contentprovidertest.R;

import java.util.ArrayList;
import java.util.List;

public class BookRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_Add;
    private EditText et_Title, et_Isbn;
    private Button btn_Retrieve,btn_delete_data;
    private List<BookInformation> bookInfoArrayList = new ArrayList<>();
    ListView listView;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_register);
        setReferences();
        setListeners();
        setAdaptor();
    }

    /*Method is used to set the adaptor */
    private void setAdaptor() {
        bookAdapter = new BookAdapter(this, bookInfoArrayList);
        listView.setAdapter(bookAdapter);
    }


    protected void setListeners() {
        btn_Add.setOnClickListener(this);
        btn_Retrieve.setOnClickListener(this);
        btn_delete_data.setOnClickListener(this);
    }


    protected void setReferences() {
        btn_Add              = (Button) findViewById(R.id.btn_Add);
        btn_Retrieve         = (Button) findViewById(R.id.btn_Retrieve);
        listView             = (ListView) findViewById(R.id.listView);
        et_Title              = (EditText) findViewById(R.id.et_Title);
        et_Isbn              =  (EditText) findViewById(R.id.et_Isbn);
        btn_delete_data           = (Button)  findViewById(R.id.btn_delete_data);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Add:
                addBooksInfo();
                break;
            case R.id.btn_Retrieve:
                retrieveBooks();
                bookAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_delete_data:
                deleteData();
                bookAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }

    private void deleteData() {

        String selectionClause =BooksProvider.TITLE + " LIKE ?";
        String[] selectionArgs = { et_Title.getText().toString()};

        int rowsDeleted = getContentResolver().delete(
                BooksProvider.CONTENT_URI,
                selectionClause,
                selectionArgs
        );
        Toast.makeText(BookRegisterActivity.this, ""+rowsDeleted, Toast.LENGTH_SHORT).show();

    }

    private void retrieveBooks() {

        Uri alltitles = Uri.parse("content://com.contantprovider.Books/books");
        Cursor cursor = getContentResolver().query(alltitles, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(cursor.getColumnIndex(
                        BooksProvider.TITLE));

                String isbn = cursor.getString(cursor.getColumnIndex(
                        BooksProvider.ISBN));

                Toast.makeText(getBaseContext(), "ContentProviders " +
                        cursor.getString(cursor.getColumnIndex(
                                BooksProvider.ID)) + ", " +
                        title + ", " +
                        isbn + "", Toast.LENGTH_LONG).show();

                bookInfoArrayList.add(new BookInformation(title, isbn));
            } while (cursor.moveToNext());
        }

    }


    private void addBooksInfo() {
        ContentValues values = new ContentValues();

        values.put(BooksProvider.TITLE, (et_Title.getText().toString()));

        values.put(BooksProvider.ISBN, (et_Isbn.getText().toString()));

        Uri uri = getContentResolver().insert(
                BooksProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(), uri.toString(),
                Toast.LENGTH_LONG).show();

    }



}
