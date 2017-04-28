package com.example.dialog.ui.Datepicker;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;
import com.example.dialog.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * create class DatepickerFragment
 * which extends Daiolog Fragment.
 */
public class DatePickerFragment extends DialogFragment implements  DatePickerDialog.OnDateSetListener{


     Calendar calendar = Calendar.getInstance();
    Context context;
    public DatePickerFragment(Context context) {
        this.context = context;
    }


    /**
     *  we override the
     *  Dialog OnCreate.
     */

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //  return new DatePickerDialog(getActivity(), this,year,month,day);




        DatePickerDialog dpd = new DatePickerDialog(getActivity(),this,year,month,day);

        calendar.add(Calendar.YEAR, 1);
       // calendar.add(calendar.MONTH,3);
        // Set the Calendar new year as maximum year of date picker
        dpd.getDatePicker().setMaxDate(calendar.getTimeInMillis());

        // Subtract 10 year from Calendar updated date
        calendar.add(Calendar.YEAR,-10);

        // Set the Calendar new date as minimum date of date picker
        dpd.getDatePicker().setMinDate(calendar.getTimeInMillis());
        return dpd;


    }

    /**
     *  set date in
     *  our text box.
     */
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


        TextView textview     = (TextView) getActivity().findViewById(R.id.tv_setdate);

        // textview.setText(dayOfMonth+":"+" "+(month+1)+":"+"   "+year);

     //   Calendar cal = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(year, month, dayOfMonth, 0, 0, 0);
        Date chosenDate = calendar.getTime();

        // Format the date using style and locale
        DateFormat df = DateFormat.getDateInstance();
        String formattedDate = df.format(chosenDate);

        // Display the chosen date to app interface
        textview.setText(formattedDate);



    }
}
