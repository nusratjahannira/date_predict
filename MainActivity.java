package com.example.rifat.date_predict;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    private TextView textview3;
    private TextView textview5;

    private Button button;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textview3 = (TextView) findViewById(R.id.textviewId3);
        textview5 = (TextView) findViewById(R.id.textviewId5);
        button = (Button) findViewById(R.id.buttonId);

        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


        DatePicker datePicker = new DatePicker(this);
        int currentDay, currentMonth , currentYear ;
            currentDay = (datePicker.getDayOfMonth());
            currentMonth = (datePicker.getMonth())+1;
            currentYear = (datePicker.getYear());

        datePickerDialog = new DatePickerDialog(this,


                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                       int day = dayOfMonth +7 ;
                       int mon = month + 9;
                       int yrr = year;

                        if(day>30 && mon>12 )
                        {
                            yrr = year +1;

                        }
                       if(day>30) {
                           day = day - 30;

                       }
                       if(mon >12)
                       {
                           mon = mon - 12;
                       }


                            textview5.setText((day) + " - " + (mon) + " - " + yrr);

                         textview3.setText((dayOfMonth)+"  -  "+(month+1)+"  -  "+year);


                    }
                },currentYear,currentMonth,currentDay);




        datePickerDialog.show();


    }
}