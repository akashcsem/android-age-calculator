package com.example.akash.agecalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public  int count = 0;

    public void okButton(View x) {
        TextView resultText = (TextView)findViewById(R.id.resultText);
        TextView finalText = (TextView)findViewById(R.id.finalText);

        EditText userDay = (EditText)findViewById(R.id.userDay);
        EditText userMonth = (EditText)findViewById(R.id.userMonth);
        EditText userYear = (EditText)findViewById(R.id.userYear);

        ImageView image = (ImageView)findViewById(R.id.imageView);
        int userD = Integer.parseInt(userDay.getText().toString());
        int userM = Integer.parseInt(userMonth.getText().toString());
        int userY = Integer.parseInt(userYear.getText().toString());


        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DATE);
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);


        if(day < userD) {
            day += 30;
            month--;
        }
        if(month < userM) {
            month += 12;
            year--;
        }

        day -= userD;
        month -= userM;
        year -= userY;

        if(userD < 1 || userD > 31)
            resultText.setText("আপনার দিন বসানো ঠিক হয়নি, দিন [১-৩১]");
        else if(userM < 0 || userM > 12)
            resultText.setText("আপনার মাস বসানো ঠিক হয়নি, মাস [১-১২]");
        else if(year < 0)
            resultText.setText("আপনি এখনো জন্ম গ্রহন করেন নি");
        else {
            if(year>0 && year<6) {
                resultText.setText("আপনার বয়স " + year + " বছর " + month + " মাস " + day + " দিন");
                image.setImageResource(R.drawable.baby);
                finalText.setText("আপনি এখনো শিশু");
            }
            else if(year>5 && year<17) {
                resultText.setText("আপনার বয়স " + year + " বছর " + month + " মাস " + day + " দিন");
                image.setImageResource(R.drawable.boy);
                finalText.setText("আপনি এখন বালক/বালিকা");
            } else if(year>16 && year<41) {
                resultText.setText("আপনার বয়স " + year + " বছর " + month + " মাস " + day + " দিন");
                image.setImageResource(R.drawable.man);
                finalText.setText("আপনি এখন প্রাপ্ত বয়স্ক");
            } else {
                resultText.setText("আপনার বয়স " + year + " বছর " + month + " মাস " + day + " দিন");
                image.setImageResource(R.drawable.old);
                finalText.setText("আপনি এখন বৃদ্ধ");
            }
        }
    }

}
