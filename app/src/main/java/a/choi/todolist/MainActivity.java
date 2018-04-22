package a.choi.todolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout inLayout = (LinearLayout) findViewById(R.id.planLayout);
        final LinearLayout planView = (LinearLayout) findViewById(R.id.planLayout);
        final ImageButton add = (ImageButton) findViewById(R.id.addButton);

        firstButton();
        dateSet();
        add.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count >= 5){}else {
                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.plan_textview, planView, true);
                    count++;
                }
            }
        });
    }

    public void dateSet(){

        TextView mood = (TextView) findViewById(R.id.moodView);
        Calendar today = Calendar.getInstance();
        int cal_month = (today.get(Calendar.MONTH) + 1);
        int cal_day_of_week = (today.get(Calendar.DAY_OF_WEEK));
        int day = (today.get(Calendar.DAY_OF_MONTH));
        String month = null, day_of_week = null;

        switch (cal_month) {

            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }

        switch (cal_day_of_week){

            case 1:
                day_of_week = "Sunday";
                break;
            case 2:
                day_of_week = "Sunday";
                break;
            case 3:
                day_of_week = "Sunday";
                break;
            case 4:
                day_of_week = "Sunday";
                break;
            case 5:
                day_of_week = "Sunday";
                break;
            case 6:
                day_of_week = "Sunday";
                break;
            case 7:
                day_of_week = "Sunday";
                break;
        }

        mood.setText("Today is " + day_of_week + ", " + month +", " + day +"\nI know you can do your ToDoList!");
    }

    public void firstButton() {
        final LinearLayout planView = (LinearLayout) findViewById(R.id.planLayout);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.plan_textview, planView, true);
    }
}