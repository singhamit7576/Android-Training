package com.example.contentprovidertest.model;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.contentprovidertest.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Create Activity which extends AppCompactActivity.
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<ContactData> modelArrayList = new ArrayList<>();
    ListView listView;
    CustomAdapterArray Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setReference();

    }


    private void setReference() {
        listView = (ListView)  findViewById(R.id.list_view);
        this.getData();
        Adapter = new CustomAdapterArray(this,modelArrayList);
        listView.setAdapter(Adapter);

    }

    private void getData() {

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));




                Bitmap uri = loadContactPhoto(getContentResolver(),Long.valueOf(id));

                modelArrayList.add(new ContactData(name,uri,phonenumber));

            }
        }
        cursor.close();
    }

    public static Bitmap loadContactPhoto(ContentResolver cr, Long id) {
        Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, id);
        InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(cr, uri);
        if (input == null) {
            return null;
        }
        return BitmapFactory.decodeStream(input);
    }
}
