package com.example.database.InsertData;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.R;
import com.example.database.Ui.Activities.BaseActivity;

import org.w3c.dom.Text;

public class InsertActivity extends BaseActivity implements View.OnClickListener {


    private EditText tv_id;
    private TextView idView;
    private EditText et_firstname, et_lastname;
    private Button btn_newContact, btn_lookup;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {
        idView = (TextView) findViewById(R.id.idView);
        tv_id = (EditText) findViewById(R.id.tv_id);
        et_firstname = (EditText) findViewById(R.id.et_firstname);
        et_lastname = (EditText) findViewById(R.id.et_lastname);
        btn_newContact = (Button) findViewById(R.id.btn_newContact);
        btn_lookup = (Button) findViewById(R.id.btn_lookup);


    }

    @Override
    protected void onListener() {

        dbHandler = new MyDBHandler(this);
        btn_newContact.setOnClickListener(this);
        btn_lookup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_newContact:

                this.insertData();




                break;


            case R.id.btn_lookup:
                    String id = tv_id.getText().toString();
                ContactModel model = dbHandler.getContact(id);
                this.settxt(model);

//                dbHandler= new MyDBHandler(this);
//               ContactModel model = dbHandler.findContact();
//
//                if (model != null) {
//
//                    idView.setText(String.valueOf(model.getFirstName()));
//
//                    // idView.setText(String.valueOf(model.getFirstName()));
//
//                    //idView.setText(String.valueOf(model.getLastName()));
//                } else {
//                    idView.setText("No Match Found");
//                }
                break;


        }
    }

    private void settxt(ContactModel model) {

        tv_id.setText(model.getID());
        et_firstname.setText(model.getFirstName());
        et_lastname.setText(model.getLastName());


    }

    private void insertData() {

        dbHandler = new MyDBHandler(this);


        ContactModel contactModel = new ContactModel();
        contactModel.setID(Integer.parseInt(tv_id.getText().toString()));
        contactModel.setFirstName(et_firstname.getText().toString());
        contactModel.setFirstName(et_lastname.getText().toString());

        dbHandler.addContacts(contactModel);
        Toast.makeText(InsertActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        tv_id.setText("");
        et_firstname.setText("");
        et_lastname.setText("");
    }


}
