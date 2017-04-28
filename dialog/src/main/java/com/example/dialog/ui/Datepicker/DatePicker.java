package com.example.dialog.ui.Datepicker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.dialog.BaseActivity.BaseActivity;
import com.example.dialog.R;

import java.util.Calendar;

/**
 * create DatePicker Activity
 * for date which  extends my BaseClass.
 */
public class DatePicker extends BaseActivity implements View.OnClickListener {

    private Button btn_setdate;
    final Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        this.setReference();
        this.onListener();
    }


    /**
     *  setReference of
     *  our layout and
     *  button.
     */
    @Override
    protected void setReference() {
     //   final RelativeLayout rl     = (RelativeLayout) findViewById(R.id.rl);
        btn_setdate     = (Button) findViewById(R.id.btn_setdate);

    }

    /**
     *  set Listener of
     *  buttons.
     */
    @Override
    protected void onListener() {
        btn_setdate.setOnClickListener(this);

    }


    /**
     *  create fragments
     *  object and show our
     *  date.
     */
    @Override
    public void onClick(View v) {


        DialogFragment mdailog = new DatePickerFragment(this);

        // Show the date picker dialog fragment
        mdailog.show(getSupportFragmentManager(), "Date Picker");


    }
}
